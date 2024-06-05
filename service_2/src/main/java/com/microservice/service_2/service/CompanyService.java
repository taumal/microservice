package com.microservice.service_2.service;

import com.microservice.service_2.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAll();

    Company getCompany(Long Id);
}
