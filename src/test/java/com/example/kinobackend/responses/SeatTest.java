package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    private long seatId = 32;
    private String row = "E";
    private int seatInRow = 3;
    private long roomId = 2;
    Seat testSeat;

    @BeforeEach
    void setUp() {
        testSeat = new Seat(seatId, row, seatInRow, roomId);
    }

    @AfterEach
    void tearDown() {
        testSeat = null;
    }

    @Test
    void getSeatId() {
        assertEquals(seatId, testSeat.getSeatId());
    }

    @Test
    void setSeatId() {
        long setSeatId = 33;
        testSeat.setSeatId(setSeatId);
        assertEquals(setSeatId, testSeat.getSeatId());
    }

    @Test
    void getRow() {
        assertEquals(row, testSeat.getRow());
    }

    @Test
    void setRow() {
        String setRow = "purple";
        testSeat.setRow(setRow);
        assertEquals(setRow, testSeat.getRow());
    }

    @Test
    void getSeatInRow() {
        assertEquals(seatInRow, testSeat.getSeatInRow());
    }

    @Test
    void setSeatInRow() {
        int setSeatInRow = 55;
        testSeat.setSeatInRow(setSeatInRow);
        assertEquals(setSeatInRow, testSeat.getSeatInRow());
    }

    @Test
    void getRoomId() {
        assertEquals(roomId, testSeat.getRoomId());
    }

    @Test
    void setRoomId() {
        int setRoomId = 33;
        testSeat.setRoomId(setRoomId);
        assertEquals(setRoomId, testSeat.getRoomId());
    }

    @Test
    void testConstructor() {
        assertEquals(seatId, testSeat.getSeatId());
        assertEquals(row, testSeat.getRow());
        assertEquals(seatInRow, testSeat.getSeatInRow());
        assertEquals(roomId, testSeat.getRoomId());
    }
}