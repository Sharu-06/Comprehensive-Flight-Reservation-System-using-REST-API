package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiContoller {
    @GetMapping("/greet/{name}")
    public String getWelcome(@PathVariable String name){
        return "Welcome "+name;
    }
}
 