package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.EventSQL;
import com.example.kinobackend.responses.Event;
import com.example.kinobackend.responses.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EventControllerTest {

    EventController testEventController;
    EventSQL testEventSQL;

    @BeforeEach
    void setUp() {
        testEventController = new EventController();
        testEventSQL = new EventSQL();
    }

    @AfterEach
    void tearDown() {
        testEventController = null;
        testEventSQL = null;
    }

    @Test
    void getEventsForMovie() throws ParseException {
        String startDateString = "2022-07-08";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = formatterDate.parse(startDateString);
        int id = 7;
        int days = 7;
        Movie testMovie = new Movie(id, "Thor: Love and Thunder", 119, 12, "img6.png", "Nachdem sein Ruhestand von Gorr dem Götterschlächter, einem galaktischen Killer, der die Auslöschung der Götter anstrebt, unterbrochen wird, bittet Thor Odinson um die Hilfe von König Walküre, Korg und seiner Ex-Freundin Jane Foster, die nun als Mighty Thor das Mjolnir schwingt. Gemeinsam begeben sie sich auf ein erschütterndes kosmisches Abenteuer, um das Geheimnis der Rache des Götterschlächters zu lüften und ihn aufzuhalten, bevor es zu spät ist.", "Fantasy, Action, Komödie" ,startDate,"Marvel Entertainment","Taika Waititi","Chris Hemsworth, Natalie Portman, Christian Bale","\"https://www.youtube.com/embed/Go8nTmfrQd8\"");
        Event[] actualEvents = testEventController.getEventsForMovie(testMovie);
        Event[] expectedEvents = testEventSQL.getEventsForMovie(id, days);
        assertThat(expectedEvents).usingRecursiveComparison().isEqualTo(actualEvents);
    }

    @Test
    void getEvents() {
        Event[] actualEvents = testEventController.getEvents();
        Event[] expectedEvents = testEventSQL.getEventData();
        assertThat(expectedEvents).usingRecursiveComparison().isEqualTo(actualEvents);
    }

    @Test
    void getEventById() {
        int id = 3;
        Event actualEvent = testEventController.getEventById(id);
        Event expectedEvent = testEventSQL.getEventById(id);
        assertThat(expectedEvent).usingRecursiveComparison().isEqualTo(actualEvent);
    }

    @Test
    void testGetEventsForMovie() {
    }

    @Test
    void addEvent() {
    }

    @Test
    void updateEvent() {
    }
}