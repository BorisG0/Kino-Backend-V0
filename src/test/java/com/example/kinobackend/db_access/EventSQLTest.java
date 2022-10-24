package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Event;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class EventSQLTest {

    EventSQL testEventSQL;

    @BeforeEach
    void setUp() {
        testEventSQL = new EventSQL();
    }

    @AfterEach
    void tearDown() {
        testEventSQL = null;
    }

    @Test
    void getEventsForMovieId() throws ParseException {
        int movieId = 1;

        Event events[] = testEventSQL.getEventsForMovieId(movieId);
        Event actualEvent = events[2];

        String date_string = "07-11-2022";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatterDate.parse(date_string);
        Time time = Time.valueOf("18:00:00");
        Event expectedEvent = new Event(2, date, time, movieId, 3);

        assertThat(actualEvent).usingRecursiveComparison().isEqualTo(expectedEvent);
    }

    @Test
    void getEventData() throws ParseException {
        Event events[] = testEventSQL.getEventData();
        Event actualEvent = events[6];

        String date_string = "07-11-2022";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatterDate.parse(date_string);
        Time time = Time.valueOf("18:00:00");
        Event expectedEvent = new Event(7, date, time, 10, 5);

        assertThat(actualEvent).usingRecursiveComparison().isEqualTo(expectedEvent);
    }

    @Test
    void getEventById() throws ParseException {
        String date_string = "07-11-2022";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatterDate.parse(date_string);
        Time time = Time.valueOf("18:00:00");

        Event expectedEvent = new Event(2, date, time, 1, 3);
        Event actualEvent = testEventSQL.getEventById((int) expectedEvent.getId());

        assertThat(actualEvent).usingRecursiveComparison().isEqualTo(expectedEvent);
    }

    @Test
    void getEventsForMovie() {
    }

    @Test
    void addEvents() {
    }

    @Test
    void updateEvent() {
    }
}