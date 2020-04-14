package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon")
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getServiceName() {
        String url = "http://service-A/test/name";
        return restTemplate.getForObject(url, String.class);
    }

}
