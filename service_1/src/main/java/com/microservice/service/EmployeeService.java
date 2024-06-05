package com.microservice.service;

import com.microservice.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();
    List<Employee> getAllByCompany(Long companyId);
    Employee getEmployee(Long Id);
}
