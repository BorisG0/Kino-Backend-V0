package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.SeatSQL;
import com.example.kinobackend.responses.Seat;
import com.example.kinobackend.responses.SeatInEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class SeatControllerTest {

    SeatController testSeatController;
    SeatSQL testSeatSQL;

    @BeforeEach
    void setUp() {
        testSeatController = new SeatController();
        testSeatSQL = new SeatSQL();
    }

    @AfterEach
    void tearDown() {
        testSeatController = null;
        testSeatSQL = null;
    }

    @Test
    void getSeats() {
        Seat[] actualSeats = testSeatController.getSeats();
        Seat[] expectedSeats = testSeatSQL.getSeatData();
        assertThat(expectedSeats).usingRecursiveComparison().isEqualTo(actualSeats);
    }

    @Test
    void getSeatsInEventId() {
        int eventId = 5;
        SeatInEvent[] actualSeatInEvent = testSeatController.getSeatsInEventId(eventId);
        SeatInEvent[] expectedSeatInEvent = testSeatSQL.getSeatsForEventId(eventId);
        assertThat(actualSeatInEvent).usingRecursiveComparison().isEqualTo(expectedSeatInEvent);
    }
}