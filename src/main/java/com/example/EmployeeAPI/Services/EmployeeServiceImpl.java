package com.example.EmployeeAPI.Services;

import com.example.EmployeeAPI.Dao.EmployeeDao;
import com.example.EmployeeAPI.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;

    public  EmployeeServiceImpl(){

    }
    @Override
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(long e_id) {
        return employeeDao.findById(e_id);
    }

    @Override
    public Employee addEmployee(String name) {
        Date date =new Date();
        Employee employee = new Employee(name,date);
        return employeeDao.save(employee);
    }

    @Override
    public void deleteEmployee(long e_id) {
        Employee employee = employeeDao.getById(e_id);
        employeeDao.delete(employee);
    }
}
