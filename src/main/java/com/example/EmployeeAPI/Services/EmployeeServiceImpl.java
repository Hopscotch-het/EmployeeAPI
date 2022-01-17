package com.example.EmployeeAPI.Services;

import com.example.EmployeeAPI.DTO.response.EmployeeDetails;
import com.example.EmployeeAPI.Dao.EmployeeDao;
import com.example.EmployeeAPI.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;

    public  EmployeeServiceImpl(){

    }
    @Override
    public List<EmployeeDetails> getEmployees(int pageNo) {

        List<EmployeeDetails> employeeDetailsList = new LinkedList<>();
        int PAGESIZE = 5;
        Pageable pageable = PageRequest.of(pageNo,PAGESIZE);
        for (Employee employee: employeeDao.findAll(pageable)){
            EmployeeDetails employeeDetails = new EmployeeDetails();
            employeeDetails.seteId(employee.geteId());
            employeeDetails.setDateOfJoining(employee.getDateOfJoining());
            employeeDetails.seteName(employee.geteName());
            employeeDetailsList.add(employeeDetails);
        }
        return employeeDetailsList;
    }

    @Override
    public EmployeeDetails getEmployee(long eId) {
        Employee employee = employeeDao.getById(eId);

        EmployeeDetails employeeDetails = new EmployeeDetails();

        employeeDetails.seteName(employee.geteName());
        employeeDetails.seteId(employee.geteId());
        employeeDetails.setDateOfJoining(employee.getDateOfJoining());

        return employeeDetails;
    }

    @Override
    public EmployeeDetails addEmployee(com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails) {
        LocalDate dateOfJoining = LocalDate.now();
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();
        Employee employee = new Employee(employeeDetails.geteName(),dateOfJoining,createdAt,updatedAt);
        Employee employee1= employeeDao.save(employee);
        EmployeeDetails employeeDetails1 =new EmployeeDetails();
        employeeDetails1.seteId(employee1.geteId());
        employeeDetails1.seteName(employee1.geteName());
        employeeDetails1.setDateOfJoining(employee1.getDateOfJoining());
        return employeeDetails1;
    }

    @Override
    public ResponseEntity<String> deleteEmployee(long eId) {
        if(employeeDao.existsById(eId)) {
            Employee employee = employeeDao.getById(eId);
            employeeDao.delete(employee);
            return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted Successfully");
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Found");
    }

    @Override
    public ResponseEntity<String > updateEmployee(com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails) {

        if(employeeDao.existsById(employeeDetails.geteId())) {
            Employee employee = employeeDao.getById(employeeDetails.geteId());
            employee.seteName(employeeDetails.geteName());
            LocalDateTime dateTime = LocalDateTime.now();
            employee.setUpdatedAt(dateTime);
            employeeDao.save(employee);
            return ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not found");
    }
}