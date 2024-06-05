package com.microservice.service;

import com.microservice.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employees = List.of(
            new Employee(1001L, "Mafijur Rahman", "Sr. Software Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L),
            new Employee(1002L, "Rahman Munshi", "Software Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L),
            new Employee(1003L, "Abdur Rahman", "Software Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L),
            new Employee(1004L, "Mahbub Rahman", "Jr. Software Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L),
            new Employee(1005L, "Mustafijur Rahman", "Jr. Software Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2002L),
            new Employee(1006L, "Raihan Ahmed", "Web Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L),
            new Employee(1007L, "Jillur Rahman", "System Admin", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L),
            new Employee(1008L, "Mujibar Rahman", "Hr Admin", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L),
            new Employee(1009L, "Mujibul Haque", "Sr. HR Admin", LocalDate.parse("2023-04-11"), "Chuadanga", 2002L),
            new Employee(1010L, "Abdul Jalil", "HR Intern", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L),
            new Employee(1011L, "Mahfuza Akhter", "Software Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L),
            new Employee(1012L, "Monira Khanom", "Software Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L),
            new Employee(1013L, "Nazma Khanom", "Software Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2002L),
            new Employee(1014L, "Zannatul Ferdouse", "Software Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2002L),
            new Employee(1015L, "Fatima Afrose", "Software Developer", LocalDate.parse("2023-04-11"), "Chuadanga", 2001L)
    );

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public List<Employee> getAllByCompany(Long companyId) {
        return employees.stream().filter(employee ->
                employee.getCompanyId().equals(companyId))
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployee(Long Id) {
        return employees.stream().filter(employee
                -> employee.getId().equals(Id)).findAny()
                .orElse(null);
    }
}
