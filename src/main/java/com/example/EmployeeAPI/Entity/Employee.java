package com.example.EmployeeAPI.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eId;
    private String eName;
    private LocalDate dateOfJoining;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public  Employee(){

    }

    public Employee(long eId, String eName, LocalDate dateOfJoining, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.eId = eId;
        this.eName = eName;
        this.dateOfJoining = dateOfJoining;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Employee(String eName, LocalDate date, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.eName = eName;
        this.dateOfJoining = date;
        this.createdAt = createdDate;
        this.updatedAt = updatedDate;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long geteId() {
        return eId;
    }

    public void seteId(long eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}
