package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.junit.jupiter.api.Assertions.*;

class SeatInEventTest {

    String row = "E";
    int numberInRow = 11;
    int status = 1;
    int seatId = 22;
    int eventId = 3;
    SeatInEvent testSeatInEvent;

    @BeforeEach
    void setUp() {
        testSeatInEvent = new SeatInEvent(row, numberInRow, status, seatId, eventId);
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
    void getSeatId() {
        assertEquals(seatId, testSeatInEvent.getSeatId());
    }

    @Test
    void setSeatId() {
        int setSeatId = 2;
        testSeatInEvent.setSeatId(setSeatId);
        assertEquals(setSeatId, testSeatInEvent.getSeatId());
    }

    @Test
    void getEventId() {
        assertEquals(eventId, testSeatInEvent.getEventId());
    }

    @Test
    void setEventId() {
        int setEventId = 2;
        testSeatInEvent.setEventId(setEventId);
        assertEquals(setEventId, testSeatInEvent.getEventId());
    }

    @Test
    void testConstructor1(){
        SeatInEvent testSeatInEvent1 = new SeatInEvent();
        testSeatInEvent1 = null;
    }

    @Test
    void testConstructor2() {
        SeatInEvent testSeatInEvent1 = new SeatInEvent(row, numberInRow, status);
        assertEquals(row, testSeatInEvent1.getRow());
        assertEquals(numberInRow, testSeatInEvent1.getNumberInRow());
        assertEquals(status, testSeatInEvent1.getStatus());
        testSeatInEvent1 = null;
    }

    @Test
    void testConstructor3() {
        assertEquals(row, testSeatInEvent.getRow());
        assertEquals(numberInRow, testSeatInEvent.getNumberInRow());
        assertEquals(status, testSeatInEvent.getStatus());
        assertEquals(seatId, testSeatInEvent.getSeatId());
        assertEquals(eventId, testSeatInEvent.getEventId());
    }

}