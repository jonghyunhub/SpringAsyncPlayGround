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

    public void asyncCall_1() {
        log.info("[asyncCall_1] :: " + Thread.currentThread().getName());
        emailService.sendEmail();
        emailService.messagingWithCustomThreadPool();
    }


    public void asyncCall_2() {
        log.info("[asyncCall_2] :: " + Thread.currentThread().getName());
        EmailService localEmailService = new EmailService();
        localEmailService.sendEmail();
        localEmailService.messagingWithCustomThreadPool();
    }

    public void asyncCall_3() {
        log.info("[asyncCall_3] :: " + Thread.currentThread().getName());
        sendEmail();
    }

    @Async
    public void sendEmail() {
        log.info("[sendEmail] :: " + Thread.currentThread().getName());
    }
}
