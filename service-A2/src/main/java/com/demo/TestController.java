package com.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getServiceName() {
        return "service-A2--该服务的端口号是:1112";
    }

}
