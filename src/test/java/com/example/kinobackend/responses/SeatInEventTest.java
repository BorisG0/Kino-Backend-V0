package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatInEventTest {

    String row = "E";
    int numberInRow = 11;
    int status = 1;
    SeatInEvent testSeatInEvent;

    @BeforeEach
    void setUp() {
        testSeatInEvent = new SeatInEvent(row, numberInRow,status);
    }

    @AfterEach
    void tearDown() {
        testSeatInEvent = null;
    }

    @Test
    void getRow() {
        assertEquals(row, testSeatInEvent.getRow());
    }

    @Test
    void setRow() {
        String setRow = "H";
        testSeatInEvent.setRow(setRow);
        assertEquals(setRow, testSeatInEvent.getRow());
    }

    @Test
    void getNumberInRow() {
        assertEquals(numberInRow, testSeatInEvent.getNumberInRow());
    }

    @Test
    void setNumberInRow() {
        int setNumberInRow = 0;
        testSeatInEvent.setNumberInRow(setNumberInRow);
        assertEquals(setNumberInRow, testSeatInEvent.getNumberInRow());
    }

    @Test
    void getStatus() {
        assertEquals(status, testSeatInEvent.getStatus());
    }

    @Test
    void setStatus() {
        int setStatus = 2;
        testSeatInEvent.setStatus(setStatus);
        assertEquals(setStatus, testSeatInEvent.getStatus());
    }

    @Test
    void testConstructor() {
        assertEquals(row, testSeatInEvent.getRow());
        assertEquals(numberInRow, testSeatInEvent.getNumberInRow());
        assertEquals(status, testSeatInEvent.getStatus());
    }
}