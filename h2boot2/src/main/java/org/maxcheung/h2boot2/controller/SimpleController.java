package org.maxcheung.h2boot2.controller;

import org.maxcheung.h2boot2.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("simple")
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;
 
 
    @Autowired
    SimpleService simpleService;
    
    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }
    
    @GetMapping("/getValue/{key}")
    public String getValue(@PathVariable String key) {
        return simpleService.getValue(key);
    }

}