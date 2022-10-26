package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EventForFrontendTest {

    long id = 25;
    Date date = new Date(20221230);
    String time = "16:30:00";
    long movieId = 32;
    long roomId = 2;
    EventForFrontend testEventForFrontend;

    @BeforeEach
    void setUp() {
        testEventForFrontend = new EventForFrontend(id, date, time, movieId, roomId);
    }

    @AfterEach
    void tearDown() {
        testEventForFrontend = null;
    }

    @Test
    void getEvent() {
        Event actualEvent = testEventForFrontend.getEvent();
        Event expectedEvent = new Event(id, date, Time.valueOf(time), movieId, roomId);
        assertThat(actualEvent).usingRecursiveComparison().isEqualTo(expectedEvent);
    }

    @Test
    void setEvent() {
        Event expectedEvent = new Event(9, new Date(20221230), Time.valueOf("18:00:00"), 3,2);
        testEventForFrontend.setEvent(expectedEvent);
        Event actualEvent = testEventForFrontend.getEvent();
        assertThat(actualEvent).usingRecursiveComparison().isEqualTo(expectedEvent);
    }
}