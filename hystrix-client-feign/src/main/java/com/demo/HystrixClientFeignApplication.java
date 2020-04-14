package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableFeignClients中已经默认打开了断路器功能，所以这里的启动类上不需要再加@EnableCircuitBreaker注解
 */
@SpringBootApplication
@EnableFeignClients
public class HystrixClientFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixClientFeignApplication.class, args);
    }

}
