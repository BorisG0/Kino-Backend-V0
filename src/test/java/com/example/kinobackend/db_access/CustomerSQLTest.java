package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class CustomerSQLTest {

    CustomerSQL testCustomerSQL;

    @BeforeEach
    void setUp() {
        testCustomerSQL = new CustomerSQL();
    }

    @AfterEach
    void tearDown() {
        testCustomerSQL = null;
    }

    @Test
    void getCustomerData() {
        Customer Customers[] = testCustomerSQL.getCustomerData();
        Customer actualCustomer = Customers[4];
        Customer expectedCustomer = new Customer("d.melchior@sap.com", "Melchior", "Daniel", 83, 66292, 20, "Saarland", "Brostraße", "DE", "+49 157 178 9855", "GOloNs9PtS");
        assertThat(actualCustomer).usingRecursiveComparison().isEqualTo(expectedCustomer);
    }

    @Test
    void getCustomerByMailAddress() {
        Customer expectedCustomer = new Customer("d.melchior@sap.com", "Melchior", "Daniel", 83, 66292, 20, "Saarland", "Brostraße", "DE", "+49 157 178 9855", "GOloNs9PtS");
        Customer actualCustomer = testCustomerSQL.getCustomerByMailAdress(expectedCustomer.getMailAdress());
        assertThat(actualCustomer).usingRecursiveComparison().isEqualTo(expectedCustomer);
    }

    @Test
    void addCustomer() {
    }
}