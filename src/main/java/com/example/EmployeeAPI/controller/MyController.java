package com.example.EmployeeAPI.controller;

import com.example.EmployeeAPI.Entity.Employee;
import com.example.EmployeeAPI.Services.EmployeeService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to home";
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee(){
        return this.employeeService.getEmployees();
    }

    @GetMapping("/employee/{e_id}")
    public Optional<Employee> getEmployee(@PathVariable String e_id){
        return this.employeeService.getEmployee(Long.parseLong(e_id));
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee e) {
        return this.employeeService.addEmployee(e.getE_name());
    }

    @DeleteMapping("/employee/{e_id}")
    public void deleteEmployee(@PathVariable String e_id){
        employeeService.deleteEmployee(Long.parseLong(e_id));
    }

}
