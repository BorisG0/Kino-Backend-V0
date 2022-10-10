package com.example.kinobackend.db_access;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class MySqlConnectorTest {

    MySqlConnector testMySqlConnector;

    @BeforeEach
    void setUp() {
         testMySqlConnector = new MySqlConnector();
    }

    @AfterEach
    void tearDown() {
        testMySqlConnector = null;
    }

    @Test
    void putStringIntoApostrophe() {
        String testString = "testString";
        assertEquals("'"+testString+"'", testMySqlConnector.putStringIntoApostrophe(testString));
    }

    @Test
    void prepareStringForLikeOperation() {
        String testString = "testString";
        assertEquals("'%"+testString+"%'", testMySqlConnector.prepareStringForLikeOperation(testString));
    }

    @Test
    void localDateToString() {
        String string = "2022-01-01";
        LocalDate date = LocalDate.parse(string);
        assertEquals(string, testMySqlConnector.LocalDateToString(date));
    }

    @Test
    void javaUtilDateToString() throws ParseException {
        String expectedString = "2022-01-01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date actualDate = formatter.parse(expectedString);
        String actualString = testMySqlConnector.JavaUtilDateToString(actualDate);
        assertEquals(expectedString, actualString);
    }
}