package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.CustomerSQL;
import com.example.kinobackend.responses.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    CustomerController testCustomerController;

    @BeforeEach
    void setUp() {
        testCustomerController = new CustomerController();
    }

    @AfterEach
    void tearDown() {
        testCustomerController = null;
    }

    @Test
    void getCustomers() {
        Customer[] actualCustomers = testCustomerController.getCustomers();

        CustomerSQL testCustomerSQL = new CustomerSQL();
        Customer[] expectedCustomers = testCustomerSQL.getCustomerData();

        assertThat(expectedCustomers).usingRecursiveComparison().ignoringFields("birthDate").isEqualTo(actualCustomers);
        System.out.println("Test successful!");
    }

    @Test
    void getCustomerByMailAdress() {
    }

    @Test
    void addCustomer() {
    }
}