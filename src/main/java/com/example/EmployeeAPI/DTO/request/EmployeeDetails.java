package com.example.EmployeeAPI.DTO.request;

public class EmployeeDetails {
    private String eName;
    private long eId;

    public long geteId() {
        return eId;
    }

    public void seteId(long eId) {
        this.eId = eId;
    }

    public EmployeeDetails() {
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }
}
