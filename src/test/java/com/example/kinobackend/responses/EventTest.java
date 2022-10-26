package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    long id = 324;
    Date date = new Date(20221001);
    Time time = new Time(163000);
    long movieId = 923;
    long roomId = 4;
    Event testEvent;

    @BeforeEach
    void setUp() {
        testEvent = new Event(id, date, time, movieId, roomId);
    }

    @AfterEach
    void tearDown() {
        testEvent = null;
    }

    @Test
    void testToString() {
        assertEquals(("Event(id: " + id + " date: " + date + " time: " + time + " MovieId: " + movieId + " RoomId: " + roomId + ")"), testEvent.toString());
    }

    @Test
    void getId() {
        assertEquals(id, testEvent.getId());
    }

    @Test
    void setId() {
        long setId = 1234;
        testEvent.setId(setId);
        assertEquals(setId, testEvent.getId());
    }

    @Test
    void getDate() {
        assertEquals(date, testEvent.getDate());
    }

    @Test
    void setDate() {
        Date setDate = new Date(20000101);
        testEvent.setDate(setDate);
        assertEquals(setDate, testEvent.getDate());
    }

    @Test
    void getTime() {
        assertEquals(time, testEvent.getTime());
    }

    @Test
    void setTime() {
        Time setTime = new Time(235959);
        testEvent.setTime(setTime);
        assertEquals(setTime, testEvent.getTime());
    }

    @Test
    void getMovieId() {
        assertEquals(movieId, testEvent.getMovieId());
    }

    @Test
    void setMovieId() {
        long setMovieId = 5678;
        testEvent.setMovieId(setMovieId);
        assertEquals(setMovieId, testEvent.getMovieId());
    }

    @Test
    void getRoomId() {
        assertEquals(roomId, testEvent.getRoomId());
    }

    @Test
    void setRoomId() {
        long setRoomId = 9012;
        testEvent.setRoomId(setRoomId);
        assertEquals(setRoomId, testEvent.getRoomId());
    }

    @Test
    void testConstructor1(){
        assertEquals(id, testEvent.getId());
        assertEquals(date, testEvent.getDate());
        assertEquals(time, testEvent.getTime());
        assertEquals(movieId, testEvent.getMovieId());
        assertEquals(roomId, testEvent.getRoomId());
    }

    @Test
    void testConstructor2(){
        testEvent = new Event();
        assertThat(new Event()).usingRecursiveComparison().isEqualTo(testEvent);
    }
}