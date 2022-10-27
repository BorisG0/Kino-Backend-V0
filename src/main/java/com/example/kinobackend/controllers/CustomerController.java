package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.CustomerSQL;
import com.example.kinobackend.db_access.MovieSQL;
import com.example.kinobackend.responses.Customer;
import com.example.kinobackend.responses.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CustomerController {

    @GetMapping("/api/customers")
    public Customer[] getCustomers(){
        System.out.println("getting customers");
        CustomerSQL connector = new CustomerSQL();
        Customer[] customers = connector.getCustomerData();
        return customers;
    }
    @PostMapping("/api/customerByMailAdress")
    public Customer getCustomerByMailAdress(@RequestBody String mailAdress){
        System.out.println("getting customers by Mail Adress");
        CustomerSQL connector = new CustomerSQL();
        Customer customer = connector.getCustomerByMailAdress(mailAdress);
        return customer;
    }
    @PostMapping("/api/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        CustomerSQL connector = new CustomerSQL();
        System.out.println("adding Customer");
        Customer returnCustomer = connector.addCustomer(customer);
        String returnString = "Customer added" + connector.getCustomerByMailAdress(customer.getMailAdress());
        System.out.println(returnString);
        return returnCustomer;
    }
}
