package com.example.EmployeeAPI.controller;

import com.example.EmployeeAPI.DTO.response.EmployeeDetails;
import com.example.EmployeeAPI.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to home";
    }

    @GetMapping("/employee")
    public List<EmployeeDetails> getEmployee(@RequestParam("page") Integer pageNo){
        return this.employeeService.getEmployees(pageNo);
    }

    @GetMapping("/employee/{eId}")
    public EmployeeDetails getEmployee(@PathVariable String eId){
        return this.employeeService.getEmployee(Long.parseLong(eId));
    }

    @PostMapping("/employee")
    public EmployeeDetails addEmployee(@RequestBody com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails) {
        return this.employeeService.addEmployee(employeeDetails);
    }

    @DeleteMapping("/employee/{eId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String eId){
        return employeeService.deleteEmployee(Long.parseLong(eId));
    }

    @PutMapping("/employee")
    public ResponseEntity<String> updateEmployee(@RequestBody com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails){
        return this.employeeService.updateEmployee(employeeDetails);
    }

}
