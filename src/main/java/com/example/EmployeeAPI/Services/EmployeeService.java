package com.example.EmployeeAPI.Services;

import com.example.EmployeeAPI.DTO.response.EmployeeDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeDetails> getEmployees(int pageNo);

    public EmployeeDetails getEmployee(long eId);

    public EmployeeDetails addEmployee(com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails);

    public ResponseEntity<String> deleteEmployee(long eId);

    public ResponseEntity<String> updateEmployee(com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails);
}
