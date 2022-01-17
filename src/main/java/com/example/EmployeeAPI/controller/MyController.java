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

    @GetMapping("/employee/page/{pageNo}")
    public List<EmployeeDetails> getEmployee(@PathVariable Integer pageNo){
        return this.employeeService.getEmployees(pageNo);
    }

    @GetMapping("/employee/{e_id}")
    public EmployeeDetails getEmployee(@PathVariable String e_id){
        return this.employeeService.getEmployee(Long.parseLong(e_id));
    }

    @PostMapping("/employee")
    public EmployeeDetails addEmployee(@RequestBody com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails) {
        return this.employeeService.addEmployee(employeeDetails);
    }

    @DeleteMapping("/employee/{e_id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String e_id){
        return employeeService.deleteEmployee(Long.parseLong(e_id));
    }

    @PutMapping("/employee")
    public ResponseEntity<String> updateEmployee(@RequestBody com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails){
        return this.employeeService.updateEmployee(employeeDetails);
    }

}
