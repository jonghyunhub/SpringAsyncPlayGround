package com.study.springasyncplayground.async.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    @Async("defaultTaskExecutor")
    public void sendEmail(){
      log.info("[sendEmail] :: " + Thread.currentThread().getName());
    }

    @Async("messagingTaskExecutor")
    public void messagingWithCustomThreadPool(){
        log.info("[messagingTaskExecutor] :: " + Thread.currentThread().getName());
    }
}
