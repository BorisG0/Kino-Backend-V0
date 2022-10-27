package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    int id = 56;
    String row = "X";
    int numberInRow = 3;
    int status = 1;
    int defaultPrice = 12;
    Ticket testTicket;

    @BeforeEach
    void setUp() {
        testTicket = new Ticket(id, row, numberInRow, status, defaultPrice);
    }

    @AfterEach
    void tearDown() {
        testTicket = null;
    }

    @Test
    void getId() {
        assertEquals(id, testTicket.getId());
    }

    @Test
    void setId() {
        int expectedId = 54;
        testTicket.setId(expectedId);
        assertEquals(expectedId, testTicket.getId());
    }

    @Test
    void getRow() {
        assertEquals(row, testTicket.getRow());
    }

    @Test
    void setRow() {
        String expectedRow = "Z";
        testTicket.setRow(expectedRow);
        assertEquals(expectedRow, testTicket.getRow());
    }

    @Test
    void getNumberInRow() {
        assertEquals(numberInRow, testTicket.getNumberInRow());
    }

    @Test
    void setNumberInRow() {
        int expectedNumberInRow = 14;
        testTicket.setNumberInRow(expectedNumberInRow);
        assertEquals(expectedNumberInRow, testTicket.getNumberInRow());
    }

    @Test
    void getStatus() {
        assertEquals(status, testTicket.getStatus());
    }

    @Test
    void setStatus() {
        int expectedStatus = 0;
        testTicket.setStatus(expectedStatus);
        assertEquals(expectedStatus, testTicket.getStatus());
    }

    @Test
    void getDefaultPrice() {
        assertEquals(defaultPrice, testTicket.getDefaultPrice());
    }

    @Test
    void setDefaultPrice() {
        int expectedDefaultPrice = 20;
        testTicket.setDefaultPrice(expectedDefaultPrice);
        assertEquals(expectedDefaultPrice, testTicket.getDefaultPrice());
    }

    @Test
    void testToString() {
        String expectedString = "Ticket: " + id + " " + status;
        String actualString = testTicket.toString();
        assertEquals(expectedString, actualString);
    }
}