package com.example.EmployeeAPI.Dao;

import com.example.EmployeeAPI.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Long> {
}
