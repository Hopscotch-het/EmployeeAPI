package com.example.EmployeeAPI.Services;

import com.example.EmployeeAPI.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getEmployees();

    public Optional<Employee> getEmployee(long e_id);

    public Employee addEmployee(String name);

    public void deleteEmployee(long e_id);
}
