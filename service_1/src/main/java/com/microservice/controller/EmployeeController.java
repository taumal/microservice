package com.microservice.controller;

import com.microservice.model.Employee;
import com.microservice.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private final EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, editor);
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> getAllEmployee() {
        List<Employee> employeeList = this.service.getAll();
        return employeeList.isEmpty() ? ResponseEntity.ok(HttpStatus.NO_CONTENT) : ResponseEntity.ok(employeeList);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        Employee employee = this.service.getEmployee(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find-by-company/{companyId}")
    public ResponseEntity<?> getEmployeeByCompany(@PathVariable Long companyId) {
        List<Employee> list = this.service.getAllByCompany(companyId);
        return list.isEmpty() ? ResponseEntity.ok(HttpStatus.NO_CONTENT) : ResponseEntity.ok(list);
    }

    /*@PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = this.service.saveOrUpdate(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-by/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
}
