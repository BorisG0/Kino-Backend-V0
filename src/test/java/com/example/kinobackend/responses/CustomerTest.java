package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    long id = 99;
    String lastName = "Nachname";
    String firstName = "Vorname";
    int age = 18;
    Customer testCustomer;

    @BeforeEach
    void setUp(){
        testCustomer = new Customer(id, lastName, firstName, age);
    }

    @AfterEach
    void tearDown() {
        testCustomer = null;
    }

    @Test
    void getId() {
        assertEquals(id, testCustomer.getId());
    }

    @Test
    void setId() {
        long setId = 100;
        testCustomer.setId(setId);
        assertEquals(setId, testCustomer.getId());
    }

    @Test
    void getFirstName() {
        assertEquals(firstName, testCustomer.getFirstName());
    }

    @Test
    void setFirstName() {
        String setFirstName = "setVorname";
        testCustomer.setFirstName(setFirstName);
        assertEquals(setFirstName, testCustomer.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals(lastName, testCustomer.getLastName());
    }

    @Test
    void setLastName() {
        String setLastName = "setLastname";
        testCustomer.setLastName(setLastName);
        assertEquals(setLastName, testCustomer.getLastName());
    }

    @Test
    void getAge() {
        assertEquals(age, testCustomer.getAge());
    }

    @Test
    void setAge() {
        int setAge = 100;
        testCustomer.setAge(setAge);
        assertEquals(setAge, testCustomer.getAge());
    }

    @Test
    void testConstructor(){
        assertEquals(id, testCustomer.getId());
        assertEquals(lastName, testCustomer.getLastName());
        assertEquals(firstName, testCustomer.getFirstName());
        assertEquals(age, testCustomer.getAge());
    }
}