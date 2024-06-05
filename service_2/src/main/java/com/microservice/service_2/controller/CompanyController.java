package com.microservice.service_2.controller;

import com.microservice.service_2.model.Company;
import com.microservice.service_2.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private final CompanyServiceImpl service;

    @Autowired
    private final RestTemplate restTemplate;

    public CompanyController(CompanyServiceImpl service, RestTemplate restTemplate) {
        this.service = service;
        this.restTemplate = restTemplate;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, editor);
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> getAll() {
        List<Company> list = this.service.getAll();
        return list.isEmpty() ? ResponseEntity.ok(HttpStatus.NO_CONTENT) : ResponseEntity.ok(list);
    }

    @GetMapping("/find-by-id/{id}")
    public Company getCompany(@PathVariable Long id) {
        Company company = this.service.getCompany(id);

        // http://localhost:9001/employee/find-by-company/2002
        List employees = restTemplate.getForObject("http://localhost:9001/api/employee/find-by-company/" + company.getId(), List.class);
        company.setEmployees(employees);

        return company;
    }

}
