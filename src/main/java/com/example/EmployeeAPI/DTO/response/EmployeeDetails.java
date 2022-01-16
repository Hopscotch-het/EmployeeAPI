package com.example.EmployeeAPI.DTO.response;

import java.time.LocalDate;

public class EmployeeDetails {
    private long eId;
    private String eName;
    private LocalDate dateOfJoining;

    public EmployeeDetails() {
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
