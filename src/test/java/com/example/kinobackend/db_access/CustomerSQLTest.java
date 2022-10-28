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
        Customer[] customers = testCustomerSQL.getCustomerData();
        Customer actualCustomer = new Customer();
        String date_string = "1999-06-19";
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = formatterDate.parse(date_string);
        Customer expectedCustomer = new Customer("gchaplynj@ezinearticles.com", "Chaplyn", "Guendolen", birthDate, 90411, 12, "Bayern", "5th Street", "DE", "+49 745 117 4164", "iNcd2ly8S9");
        for(int i = 0; i < customers.length; i++) {
            actualCustomer = customers[i];
            if(actualCustomer.getMailAdress().equals(expectedCustomer.getMailAdress())){
                break;
            }
        }
        assertThat(actualCustomer).usingRecursiveComparison().isEqualTo(expectedCustomer);
    }

    @Test
    void getCustomerByMailAddress() throws ParseException {
        String date_string = "1987-10-02";
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = formatterDate.parse(date_string);
        Customer expectedCustomer = new Customer("dsedworth6@xrea.com", "Sedworth", "Darn", birthDate, 1189, 1, "Sachsen", "Orin Hill", "DE", "+49 919 425 0372", "mieeQE6UH2v");
        Customer actualCustomer = testCustomerSQL.getCustomerByMailAdress(expectedCustomer.getMailAdress());
        assertThat(actualCustomer).usingRecursiveComparison().isEqualTo(expectedCustomer);
    }

}