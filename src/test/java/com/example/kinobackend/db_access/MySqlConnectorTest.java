package com.example.kinobackend.db_access;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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
    void javaUtilDateToString() {
        /*
        String string = "2022-01-01";
        Date date = new Date(20220101);
        assertEquals(string, testMySqlConnector.JavaUtilDateToString(date));
        */
    }
}