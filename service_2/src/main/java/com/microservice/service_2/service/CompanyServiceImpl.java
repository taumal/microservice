package com.microservice.service_2.service;

import com.microservice.service_2.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{
    List<Company> companies = List.of(
            new Company(2001L, "Tech Cloud Ltd", "+880190XXXXXXX", "Baridhara DOHS, Dhaka"),
            new Company(2002L, "Quantum Foundation", "+880167XXXXXXX", "Shanti nagar, Dhaka")
    );

    @Override
    public List<Company> getAll() {
        return companies;
    }

    @Override
    public Company getCompany(Long Id) {
        return companies.stream().filter(company ->
                company.getId().equals(Id)).findAny()
                .orElse(null);
    }
}
