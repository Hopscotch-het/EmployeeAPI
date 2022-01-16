package com.example.EmployeeAPI.Services;

import com.example.EmployeeAPI.DTO.response.EmployeeDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeDetails> getEmployees();

    public EmployeeDetails getEmployee(long e_id);

    public EmployeeDetails addEmployee(com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails);

    public ResponseEntity<String> deleteEmployee(long e_id);

    public ResponseEntity<String> updateEmployee(com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails);
}
