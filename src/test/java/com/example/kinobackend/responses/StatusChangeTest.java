package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusChangeTest {

    int id = 99;
    int status = 2;
    StatusChange testStatusChange;

    @BeforeEach
    void setUp() {
        testStatusChange = new StatusChange(id, status);
    }

    @AfterEach
    void tearDown() {
        testStatusChange = null;
    }

    @Test
    void getId() {
        assertEquals(id, testStatusChange.getId());
    }

    @Test
    void setId() {
        int expectedId = 54;
        testStatusChange.setId(expectedId);
        assertEquals(expectedId, testStatusChange.getId());
    }

    @Test
    void getStatus() {
        assertEquals(status, testStatusChange.getStatus());
    }

    @Test
    void setStatus() {
        int expectedStatus = 0;
        testStatusChange.setStatus(expectedStatus);
        assertEquals(expectedStatus, testStatusChange.getStatus());
    }
}