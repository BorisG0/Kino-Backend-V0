package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    String mailAdress = "mailAdress";
    String lastName = "Nachname";
    String firstName = "Vorname";
    int age = 18;
    int postalCode = 12345;
    int houseNumber = 1;
    String location = "location";
    String street = "street";
    String country = "country";
    String mobileNumber = "123";
    String password = "password";
    Customer testCustomer;

    @BeforeEach
    void setUp(){
        testCustomer = new Customer(mailAdress, lastName, firstName, age,postalCode,houseNumber,location,street,country,mobileNumber,password);
    }

    @AfterEach
    void tearDown() {
        testCustomer = null;
    }

    @Test
    void getFirstName() {
        assertEquals(firstName, testCustomer.getFirstname());
    }

    @Test
    void setFirstName() {
        String setFirstName = "setVorname";
        testCustomer.setFirstname(setFirstName);
        assertEquals(setFirstName, testCustomer.getFirstname());
    }

    @Test
    void getLastName() {
        assertEquals(lastName, testCustomer.getLastname());
    }

    @Test
    void setLastName() {
        String setLastName = "setLastname";
        testCustomer.setLastname(setLastName);
        assertEquals(setLastName, testCustomer.getLastname());
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
    }
}