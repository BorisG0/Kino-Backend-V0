package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Customer;
import com.example.kinobackend.responses.Employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    /*@Test
    void getUserFromLoginDataEmployee() {
        String actualString = testUserSQL.getUserFromLoginData("etebbit5@google.com.au", "0O5fYu");
        assertEquals("Employee", actualString);
    }

    @Test
    void getUserFromLoginDataCustomer() {
        String actualString = testUserSQL.getUserFromLoginData("agrealeya@who.int", "LeYfgdoAfznW");
        assertEquals("Customer", actualString);
    }

    @Test
    void getUserFromLoginDataNoData() {
        String actualString = testUserSQL.getUserFromLoginData("test@mail.com", "password");
        assertEquals("NoUserFound", actualString);
    }

     */
}