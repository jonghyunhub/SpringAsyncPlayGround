package com.study.springasyncplayground.async.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AsyncService {

    private final EmailService emailService;

    /**
     * EmailService Bean은 SpringFramework가 Proxy로 Wrapping 해서 매서드 호출시 Sub Thread로 실행
     * => 비동기 처리를 위해서는 Spring Bean으로 등록해서 사용 필요
     * => [비동기]적으로 작동
     */
    public void asyncCall_1() {
        log.info("[asyncCall_1] :: " + Thread.currentThread().getName());
        emailService.sendEmail();
        emailService.messagingWithCustomThreadPool();
    }


    /**
     * EmailService를 Bean으로 등록하지 않고 직접 인스턴스를 생성해서 사용할 경우 Sub Thread로 실행되지 않음
     * => [동기]적으로 작동
     */
    public void asyncCall_2() {
        log.info("[asyncCall_2] :: " + Thread.currentThread().getName());
        EmailService localEmailService = new EmailService();
        localEmailService.sendEmail();
        localEmailService.messagingWithCustomThreadPool();
    }

    /**
     * AsyncService.sendEmail() 메서드는 비동기로 설정했지만, 같은 Bean 내부에서 메서드를 다이렉트로 호출시
     * Proxy Wrapping이 되지 않아 Sub Thread로 실행되지 않음 => asyncCall_3 메서드 로직은 [동기]로 실행됨
     */
    public void asyncCall_3() {
        log.info("[asyncCall_3] :: " + Thread.currentThread().getName());
        sendEmail();
    }

    /**
     * Async 메서드를 사용시에는 반드시 "public"으로 선언해야 함
     */
    @Async
    public void sendEmail() {
        log.info("[sendEmail] :: " + Thread.currentThread().getName());
    }
}
