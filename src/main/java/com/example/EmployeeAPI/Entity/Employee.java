package com.example.EmployeeAPI.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long e_id;
    private String e_name;
    @Temporal(TemporalType.DATE)
    private Date date;

    public  Employee(){

    }
    public Employee(String e_name, Date date) {
        this.e_name = e_name;
        this.date = date;
    }

    public long getE_id() {
        return e_id;
    }

    public void setE_id(long e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
