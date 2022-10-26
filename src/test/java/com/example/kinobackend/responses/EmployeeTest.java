package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    String mailAdress = "meine@mailadresse.de";
    String lastname = "NachnameE";
    String firstname = "VornameV";
    String role = "Geschäftsführer";
    String password = "ichBinAdmin";
    Employee testEmployee;

    @BeforeEach
    void setUp() {
        testEmployee = new Employee(mailAdress, lastname, firstname,role, password);
    }

    @AfterEach
    void tearDown() {
        testEmployee = null;
    }

    @Test
    void getMailAdress() {
        assertEquals(mailAdress, testEmployee.getMailAdress());
    }

    @Test
    void setMailAdress() {
        String setMailAdress = "neue@mail.com";
        testEmployee.setMailAdress(setMailAdress);
        assertEquals(setMailAdress, testEmployee.getMailAdress());
    }

    @Test
    void getRole() {
        assertEquals(role, testEmployee.getRole());
    }

    @Test
    void setRole() {
        String setRole = "Mitarbeiter";
        testEmployee.setRole(setRole);
        assertEquals(setRole, testEmployee.getRole());
    }

    @Test
    void getPassword() {
        assertEquals(password, testEmployee.getPassword());
    }

    @Test
    void setPassword() {
        String setPassword = "Passwort!";
        testEmployee.setPassword(setPassword);
        assertEquals(setPassword, testEmployee.getPassword());
    }

    @Test
    void testConstructor() {
        assertEquals(mailAdress, testEmployee.getMailAdress());
        //assertEquals(lastname, testEmployee.getLastname());
        //assertEquals(firstname, testEmployee.getFirstname());
        assertEquals(role, testEmployee.getRole());
        assertEquals(password, testEmployee.getPassword());
    }

    @Test
    void testConstructor2(){
        testEmployee = new Employee();
        assertThat(new Employee()).usingRecursiveComparison().isEqualTo(testEmployee);
    }
}