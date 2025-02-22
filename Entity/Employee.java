package com.example.demo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
   
    private String password;
    public Employee(int id,String name,String password){
        this.id=id;
        this.name=name;
        this.password=password;
    }
    public int getId(){ 
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getname(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getpassword(){
        return password;
    }
    public void setpassword(String password){
        this.password=password;
    }
}
