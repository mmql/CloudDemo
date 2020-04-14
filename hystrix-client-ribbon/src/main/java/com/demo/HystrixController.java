package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {
	
  @Autowired
  private HystrixService ribbonHystrixService;

  @RequestMapping("/name")
  public String getServiceName() {
    return this.ribbonHystrixService.getServiceName();
  }
}