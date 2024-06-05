package com.microservice.service_2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private Long id;

    private String name;

    private String contact;

    private String location;

    List<Employee> employees = new ArrayList<Employee>();

    public Company(Long id, String name, String contact, String location, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.location = location;
        this.employees = employees;
    }

    public Company(Long id, String name, String contact, String location) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.location = location;
    }

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
