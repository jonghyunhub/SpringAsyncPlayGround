package com.study.springasyncplayground.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * ThreadPoolTaskExecutor Bean 정의
 * corePoolSize: 최소 스레드 개수
 * keepAliveSeconds: 쓰레드 사용 되지 않을 경우 쓰레드 삭제될 시간
 * maxPoolSize: 최대 스레드 개수
 * queueCapacity: 대기 큐 사이즈(쓰레드 개수가 maxPoolSize를 넘어갈 경우 대기 큐에 쌓아서 관리)
 */
@Configuration
public class AppConfig {

    @Bean(name = "defaultTaskExecutor", destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor defaultTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200);
        executor.setMaxPoolSize(300);
        return executor;
    }

    @Bean(name = "messagingTaskExecutor", destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor messagingTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200);
        executor.setMaxPoolSize(300);
        return executor;
    }
}
