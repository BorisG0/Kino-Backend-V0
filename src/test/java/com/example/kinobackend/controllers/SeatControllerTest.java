package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.SeatSQL;
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
    }

    @Test
    void getSeatsInEventId() {
    }

    @Test
    void setStatusForSeatInEvent() {
    }
}