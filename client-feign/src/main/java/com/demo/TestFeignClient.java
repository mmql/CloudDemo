package com.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.cloud.openfeign.FeignClient(name = "SERVICE-A")
public interface TestFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/test/name")
    public String getName();
}