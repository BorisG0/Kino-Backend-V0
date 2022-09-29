package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.CustomerSQL;
import com.example.kinobackend.responses.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/api/customers")
    public Customer[] getCustomers(){
        System.out.println("getting customers");
        CustomerSQL connector = new CustomerSQL();
        Customer[] customers = connector.getCustomerData();
        return customers;
    }
}
