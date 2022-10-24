package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.EmployeeSQL;
import com.example.kinobackend.responses.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeControllerTest {

    EmployeeController testEmployeeController;
    EmployeeSQL testEmpolyeeSQL;

    @BeforeEach
    void setUp() {
        testEmployeeController = new EmployeeController();
        testEmpolyeeSQL = new EmployeeSQL();
    }

    @AfterEach
    void tearDown() {
        testEmployeeController = null;
        testEmpolyeeSQL = null;
    }

    @Test
    void getEmployees() {
        Employee[] actualEmployees = testEmployeeController.getEmployees();
        Employee[] expectedEmployees = testEmpolyeeSQL.getEmployeeData();
        assertThat(expectedEmployees).usingRecursiveComparison().isEqualTo(actualEmployees);
    }

    @Test
    void getEmployeeByMailAdress() {
        String mailAddress = "etebbit5@google.com.au";
        Employee actualEmployee = testEmployeeController.getEmployeeByMailAdress(mailAddress);
        Employee expectedEmployee = testEmpolyeeSQL.getEmployeeByMailAdress(mailAddress);
        assertThat(expectedEmployee).usingRecursiveComparison().isEqualTo(actualEmployee);
    }

    @Test
    void addEmployee() {
    }
}