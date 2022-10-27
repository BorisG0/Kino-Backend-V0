package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    String mailAdress = "VornameNachname@mailadresse.de";
    String lastName = "Nachname";
    String firstName = "Vorname";

    String date_string = "01-01-2022";
    SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
    Date birthDate = formatterDate.parse(date_string);

    int postalCode = 12345;
    int houseNumber = 1;
    String location = "Mannheim";
    String street = "Hauptstraße";
    String countryCode = "DE";
    String mobileNumber = "0049123456789";
    String password = "sicheresPasswort";
    Customer testCustomer;

    CustomerTest() throws ParseException {
    }

    @BeforeEach
    void setUp(){
        testCustomer = new Customer(mailAdress, lastName, firstName, birthDate, postalCode, houseNumber, location, street, countryCode, mobileNumber, password);
    }

    @AfterEach
    void tearDown() {
        testCustomer = null;
    }

    @Test
    void getMailAdress(){
        assertEquals(mailAdress, testCustomer.getMailAdress());
    }

    @Test
    void setMailAdress(){
        String setMailAdress = "neueAdresse@mail.de";
        testCustomer.setMailAdress(setMailAdress);
        assertEquals(setMailAdress, testCustomer.getMailAdress());
    }

    @Test
    void getBirthDate() {
        assertEquals(birthDate, testCustomer.getBirthDate());
    }

    @Test
    void setBirthDate() throws ParseException {
        String date_string = "23-04-1985";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date setBirthDate = formatterDate.parse(date_string);
        testCustomer.setBirthDate(setBirthDate);
        assertEquals(setBirthDate, testCustomer.getBirthDate());
    }

    @Test
    void getPostalCode() {
        assertEquals(postalCode, testCustomer.getPostalCode());
    }

    @Test
    void setPostalCode() {
        int setPostalCode = 98765;
        testCustomer.setPostalCode(setPostalCode);
        assertEquals(setPostalCode, testCustomer.getPostalCode());
    }

    @Test
    void getHouseNummer() {
        assertEquals(houseNumber, testCustomer.getHouseNumber());
    }

    @Test
    void setHouseNumber() {
        int setHouseNumber = 76;
        testCustomer.setHouseNumber(setHouseNumber);
        assertEquals(setHouseNumber, testCustomer.getHouseNumber());
    }

    @Test
    void getLocation() {
        assertEquals(location, testCustomer.getLocation());
    }

    @Test
    void setLocation() {
        String setLocation = "Hamburg";
        testCustomer.setLocation(setLocation);
        assertEquals(setLocation, testCustomer.getLocation());
    }

    @Test
    void getStreet() {
        assertEquals(street, testCustomer.getStreet());
    }

    @Test
    void setStreet() {
        String setStreet = "Bahnhofstraße";
        testCustomer.setStreet(setStreet);
        assertEquals(setStreet, testCustomer.getStreet());
    }

    @Test
    void getCountryCode() {
        assertEquals(countryCode, testCustomer.getCountryCode());
    }

    @Test
    void setCountryCode() {
        String setCountryCode = "FR";
        testCustomer.setCountryCode(setCountryCode);
        assertEquals(setCountryCode, testCustomer.getCountryCode());
    }

    @Test
    void getMobileNumber() {
        assertEquals(mobileNumber, testCustomer.getMobileNumber());
    }

    @Test
    void setMobileNumber() {
        String setMobileNumber = "+331234567";
        testCustomer.setMobileNumber(setMobileNumber);
        assertEquals(setMobileNumber, testCustomer.getMobileNumber());
    }

    @Test
    void getPassword() {
        assertEquals(password, testCustomer.getPassword());
    }

    @Test
    void setPassword() {
        String setPassword = "geheim!!!";
        testCustomer.setPassword(setPassword);
        assertEquals(setPassword, testCustomer.getPassword());
    }

    @Test
    void testConstructor(){
        assertEquals(mailAdress, testCustomer.getMailAdress());
        //assertEquals(lastName, testCustomer.getLastname());
        //assertEquals(firstName, testCustomer.getFirstname());
        assertEquals(birthDate, testCustomer.getBirthDate());
        assertEquals(postalCode, testCustomer.getPostalCode());
        assertEquals(houseNumber, testCustomer.getHouseNumber());
        assertEquals(location, testCustomer.getLocation());
        assertEquals(street, testCustomer.getStreet());
        assertEquals(countryCode, testCustomer.getCountryCode());
        assertEquals(mobileNumber, testCustomer.getMobileNumber());
        assertEquals(password, testCustomer.getPassword());
    }

    @Test
    void testConstructor2(){
        testCustomer = new Customer();
        assertThat(new Customer()).usingRecursiveComparison().isEqualTo(testCustomer);
    }

    @Test
    void testConstructor3(){
        String mailAdress = "test@mail.com";
        testCustomer = new Customer(mailAdress);
        assertThat(new Customer(mailAdress)).usingRecursiveComparison().isEqualTo(testCustomer);
    }
}