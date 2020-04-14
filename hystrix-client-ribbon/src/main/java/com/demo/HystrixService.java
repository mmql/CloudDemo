package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixService {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixService.class);

    /**
     * 使用 @HystrixCommand 注解 指定当该方法发生异常时调用的方法
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public String getServiceName() {
        return restTemplate.getForEntity("http://service-A/test/name", String.class).getBody();
    }

    /**
     * 发生异常时调用的 方法具体实现，与注解@HystrixCommand里的命名对应
     * 可以在这里 将异常入数据库，打出日志等等
     * 配置的fallbackMethod方法必须与被@HystrixCommand注解的方法有意向的入参和返回值
     */
    public String fallback() {
        HystrixService.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", "qqq");
        return "ribbon 中的断路器开启";
    }
}