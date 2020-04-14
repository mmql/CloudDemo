package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultFallback implements TestFeignClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultFallback.class);

    @Override
    public String getName() {
        DefaultFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数： {},{}");
        return "feign中的断路器开启 ";
    }
}
