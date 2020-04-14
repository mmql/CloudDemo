package com.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ClientRibbonApplication {
    private static final Logger logger = LogManager.getLogger(com.demo.ClientRibbonApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ClientRibbonApplication.class, args);
    }


    /**
     * Spring提供的用于访问Rest服务的客户端，并将其设置为负载均衡的
     *
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        logger.info("LoadBalanced restTemplate from ribbon client");
        return new RestTemplate();
    }
}
