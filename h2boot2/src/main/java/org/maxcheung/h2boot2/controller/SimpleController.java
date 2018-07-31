package org.maxcheung.h2boot2.controller;

import org.maxcheung.h2boot2.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("simple")
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;
 
    @Value("${spring.profile}")
    String profile;
 
    @Autowired
    SimpleService simpleService;
    
    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }
    
    @GetMapping("/getValue")
    public String getValue() {
        return simpleService.getValue(profile, "key1");
    }
}