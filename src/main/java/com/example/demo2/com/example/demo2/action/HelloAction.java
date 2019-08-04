package com.example.demo2.com.example.demo2.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAction {
    @GetMapping("/hellos")
    public String hello(){
        return "hello world";
    }

}
