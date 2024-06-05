package com.microservice.service_2.model;

import java.time.LocalDate;

public class Employee {
    private Long id;

    private String name;

    private String designation;

    private LocalDate joiningDate;

    private String jobLocation;

    private Long companyId;

    public Employee() {
    }

    public Employee(Long id, String name, String designation, LocalDate joiningDate, String jobLocation, Long companyId) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.jobLocation = jobLocation;
        this.companyId = companyId;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
