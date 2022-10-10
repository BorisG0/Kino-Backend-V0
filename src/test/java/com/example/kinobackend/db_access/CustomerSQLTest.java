package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    }

    @Test
    void getCustomerByMailAddress() {
        Customer expectedCustomer = new Customer("d.melchior@sap.com", "Melchior", "Daniel", 83, 66292, 20, "Saarland", "Brostraße", "DE", "+49 157 178 9855", "GOloNs9PtS");
        Customer actualCustomer = testCustomerSQL.getCustomerByMailAdress("d.melchior@sap.com");
        assertThat(actualCustomer).usingRecursiveComparison().isEqualTo(expectedCustomer);
    }

    @Test
    void addCustomer() {
    }
}