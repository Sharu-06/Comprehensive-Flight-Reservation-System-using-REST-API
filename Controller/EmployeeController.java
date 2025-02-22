package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeService empservice;

    @PostMapping("/add")
    public Employee insertEmployee(@RequestBody Employee emp){
        return empservice.addEmployee(emp);
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployees(){
        return empservice.getEmployee();
    }

    /*@PutMapping("update/(id)")
    public Employee updateEmployee(&Pathvariable Long id,@RequestBody Employee emp){
        return empservice,updateEmployee(id,emp);
    }*/
}
