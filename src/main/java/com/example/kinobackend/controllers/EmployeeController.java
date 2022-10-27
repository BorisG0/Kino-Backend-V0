package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.EmployeeSQL;
import com.example.kinobackend.responses.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/api/employeeByMailAdress")
    public Employee getEmployeeByMailAdress(@RequestBody String mailAdress){
        System.out.println("getting employee by Mail Adress");
        EmployeeSQL connector = new EmployeeSQL();
        Employee employee = connector.getEmployeeByMailAdress(mailAdress);
        return employee;
    }
}
