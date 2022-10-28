package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.CustomerSQL;
import com.example.kinobackend.responses.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;


class CustomerControllerTest {

    CustomerController testCustomerController;
    CustomerSQL testCustomerSQL;

    @BeforeEach
    void setUp() {
        testCustomerController = new CustomerController();
        testCustomerSQL = new CustomerSQL();
    }

    @AfterEach
    void tearDown() {
        testCustomerController = null;
        testCustomerSQL = null;
    }

    @Test
    void getCustomers() {
        Customer[] actualCustomers = testCustomerController.getCustomers();
        Customer[] expectedCustomers = testCustomerSQL.getCustomerData();
        assertThat(expectedCustomers).usingRecursiveComparison().isEqualTo(actualCustomers);
    }

    @Test
    void getCustomerByMailAdress() {
        String mailAddress = "llighten7@adobe.com";
        Customer actualCustomer = testCustomerController.getCustomerByMailAdress(mailAddress);
        Customer expectedCustomer = testCustomerSQL.getCustomerByMailAdress(mailAddress);
        assertThat(expectedCustomer).usingRecursiveComparison().isEqualTo(actualCustomer);
    }

}