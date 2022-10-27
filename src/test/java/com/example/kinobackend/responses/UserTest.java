package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User.UserType userType = User.UserType.Employee;
    String mailAdress = "meine@mail.de";
    String password = "aslöjkljds";
    String lastName = "Nachname";
    String firstName = "Vorname";
    User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User(userType, mailAdress, password, lastName, firstName);
    }

    @AfterEach
    void tearDown() {
        testUser = null;
    }

    @Test
    void getUserType() {
        assertEquals(userType, testUser.getUserType());
    }

    @Test
    void setUserType() {
        User.UserType setUserType = User.UserType.Customer;
        testUser.setUserType(setUserType);
        assertEquals(setUserType, testUser.getUserType());
    }

    @Test
    void getMailAdress() {
        assertEquals(mailAdress, testUser.getMailAdress());
    }

    @Test
    void setMailAdress() {
        String setMailAdress = "neue@mail.com";
        testUser.setMailAdress(setMailAdress);
        assertEquals(setMailAdress, testUser.getMailAdress());
    }

    @Test
    void getPassword() {
        assertEquals(password, testUser.getPassword());
    }

    @Test
    void setPassword() {
        String setPassword = "Passwort!";
        testUser.setPassword(setPassword);
        assertEquals(setPassword, testUser.getPassword());
    }

    @Test
    void getLastName() {
        assertEquals(lastName, testUser.getLastName());
    }

    @Test
    void setLastName() {
        String setLastName = "NeuerName";
        testUser.setLastName(setLastName);
        assertEquals(setLastName, testUser.getLastName());
    }

    @Test
    void getFirstName() {
        assertEquals(firstName, testUser.getFirstName());
    }

    @Test
    void setFirstName() {
        String setFirstName = "NeuerName2";
        testUser.setFirstName(setFirstName);
        assertEquals(setFirstName, testUser.getFirstName());
    }

    @Test
    void testConstructor1() {
        User testUser1 = new User(mailAdress, password);
        assertEquals(mailAdress, testUser1.getMailAdress());
        assertEquals(password, testUser1.getPassword());
        testUser1 = null;
    }

    @Test
    void testConstructor2() {
        assertEquals(userType, testUser.getUserType());
        assertEquals(mailAdress, testUser.getMailAdress());
        assertEquals(password, testUser.getPassword());
        assertEquals(lastName, testUser.getLastName());
        assertEquals(firstName, testUser.getFirstName());
    }

    @Test
    void testConstructor3() {
        User testUser1 = new User(mailAdress);
        assertEquals(mailAdress, testUser1.getMailAdress());
        testUser1 = null;
    }
}