package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Customer;
import com.example.kinobackend.responses.Employee;

import com.example.kinobackend.responses.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserSQLTest {

    UserSQL testUserSQL;

    @BeforeEach
    void setUp() {
        testUserSQL = new UserSQL();
    }

    @AfterEach
    void tearDown() {
        testUserSQL = null;
    }

    @Test
    void getEmployeeFromLoginData() {
        String mailAddress = "osilk4@nationalgeographic.com";
        String password = "1aGSxKVP";
        User actualUser = testUserSQL.getUserFromLoginData(mailAddress, password);
        Employee expectedEmployee = new Employee(mailAddress, "Byrcher", "Gaëlle", "Manager", password);
        assertThat(actualUser).usingRecursiveComparison().isEqualTo(expectedEmployee);
    }

    @Test
    void getCustomerFromLoginData() throws ParseException {
        String mailAddress = "lisa.schmidt@studentsDHBW.com";
        String password = "123";
        User actualUser = testUserSQL.getUserFromLoginData(mailAddress, password);
        String date_string = "30-04-1980";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = formatterDate.parse(date_string);
        Customer expectedCustomer = new Customer(mailAddress, "Schmidt", "Lisa", birthDate, 9116, 86, "Sachsen", "Monterey Place", "DE", "+49 390 982 5080", password);
        assertThat(actualUser).usingRecursiveComparison().isEqualTo(expectedCustomer);
    }

    @Test
    void getNewUserFromLoginData() {
        String mailAddress = "neue@adresse.de";
        String password = "sicheresPasswort";
        User actualUser = testUserSQL.getUserFromLoginData(mailAddress, password);
        User expectedUser = new User(mailAddress, password);
        expectedUser.setFirstName("");
        expectedUser.setLastName("");
        assertThat(actualUser).usingRecursiveComparison().isEqualTo(expectedUser);
    }
}