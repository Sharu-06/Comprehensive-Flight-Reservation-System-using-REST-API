package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")


public class DemoController {
    @Value("${emp.dept}")
    private String department;
    @Value("${emp.sal:333}")
    private String salary;
    @GetMapping("/dept")
    public String getValue(){
        return department;
    }
    @GetMapping("/sal")
    public String getSal(){
        return salary;
    }
    @Value("${JAVA_HOME}")
    private String javahome;
    @GetMapping("/java")
    public String gethome(){
        return javahome;
    }

}
