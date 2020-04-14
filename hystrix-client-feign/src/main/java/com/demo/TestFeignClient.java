package com.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SERVICE-A", fallback = DefaultFallback.class)
public interface TestFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/test/name")
    String getName();

}