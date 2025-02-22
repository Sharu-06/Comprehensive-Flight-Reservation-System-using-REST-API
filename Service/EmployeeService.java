package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service

public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;
    
    public Employee addEmployee(Employee emp){
        return empRepo.save(emp);
    }
    
    public List<Employee> getEmployee() {
        return empRepo.findAll();
    }
    
}
