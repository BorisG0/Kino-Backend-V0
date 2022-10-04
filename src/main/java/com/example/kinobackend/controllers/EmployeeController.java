package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.CustomerSQL;
import com.example.kinobackend.db_access.EmployeeSQL;
import com.example.kinobackend.responses.Customer;
import com.example.kinobackend.responses.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/api/employees")
    public Employee[] getEmployees(){
        System.out.println("getting employees");
        EmployeeSQL connector = new EmployeeSQL();
        Employee[] employees = connector.getEmployeeData();
        return employees;
    }
}
