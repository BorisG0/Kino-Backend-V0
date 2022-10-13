package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    void getCustomerData() throws ParseException {
        Customer Customers[] = testCustomerSQL.getCustomerData();
        Customer actualCustomer = Customers[4];
        String date_string = "23-04-1985";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = formatterDate.parse(date_string);
        Customer expectedCustomer = new Customer("d.melchior@sap.com", "Melchior", "Daniel", birthDate, 66292, 20, "Saarland", "Brostraße", "DE", "+49 157 178 9855", "GOloNs9PtS");
        assertThat(actualCustomer).usingRecursiveComparison().isEqualTo(expectedCustomer);
    }

    @Test
    void getCustomerByMailAddress() throws ParseException {
        String date_string = "23-04-1985";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = formatterDate.parse(date_string);
        Customer expectedCustomer = new Customer("d.melchior@sap.com", "Melchior", "Daniel", birthDate, 66292, 20, "Saarland", "Brostraße", "DE", "+49 157 178 9855", "GOloNs9PtS");
        Customer actualCustomer = testCustomerSQL.getCustomerByMailAdress(expectedCustomer.getMailAdress());
        assertThat(actualCustomer).usingRecursiveComparison().isEqualTo(expectedCustomer);
    }

    @Test
    void addCustomer() {
    }

}