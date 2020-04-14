package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private TestFeignClient testFeignClient;

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getName() {
        return this.testFeignClient.getName();
    }
}