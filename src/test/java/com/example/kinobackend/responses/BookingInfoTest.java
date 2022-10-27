package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookingInfoTest {

    int id = 634;
    int pricePaid = 13;
    String[] seatPlaces = {"E1", "X5"};
    String movieTitle = "Blues Brothers";
    String date_string = "11-11-2022";
    SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
    Date date = formatterDate.parse(date_string);
    Time time =Time.valueOf("17:45:00");

    BookingInfo testBookingInfo;

    BookingInfoTest() throws ParseException {
    }

    @BeforeEach
    void setUp() {
        testBookingInfo = new BookingInfo(id, pricePaid, seatPlaces, movieTitle, date, time);
    }

    @AfterEach
    void tearDown() {
        testBookingInfo = null;
    }

    @Test
    void getId() {
        assertEquals(id, testBookingInfo.getId());
    }

    @Test
    void setId() {
        int expectedId = 23;
        testBookingInfo.setId(expectedId);
        assertEquals(expectedId, testBookingInfo.getId());
    }

    @Test
    void getPricePaid() {
        assertEquals(pricePaid, testBookingInfo.getPricePaid());
    }

    @Test
    void setPricePaid() {
        int expectedPricePaid = 12;
        testBookingInfo.setPricePaid(expectedPricePaid);
        assertEquals(expectedPricePaid, testBookingInfo.getPricePaid());
    }

    @Test
    void getSeatPlaces() {
        assertEquals(seatPlaces, testBookingInfo.getSeatPlaces());
    }

    @Test
    void setSeatPlaces() {
        String[] expectedSeatPlaces = {"E3", "T4", "A5"};
        testBookingInfo.setSeatPlaces(expectedSeatPlaces);
        assertEquals(expectedSeatPlaces, testBookingInfo.getSeatPlaces());
    }

    @Test
    void getMovieTitle() {
        assertEquals(movieTitle, testBookingInfo.getMovieTitle());
    }

    @Test
    void setMovieTitle() {
        String expectedMovieTitle = "Mario";
        testBookingInfo.setMovieTitle(expectedMovieTitle);
        assertEquals(expectedMovieTitle, testBookingInfo.getMovieTitle());
    }

    @Test
    void getDate() {
        assertEquals(date, testBookingInfo.getDate());
    }

    @Test
    void setDate() throws ParseException {
        String date_string = "31-12-2022";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date expectedDate = formatterDate.parse(date_string);
        testBookingInfo.setDate(expectedDate);
        assertEquals(expectedDate, testBookingInfo.getDate());
    }

    @Test
    void getTime() {
        assertEquals(time, testBookingInfo.getTime());
    }

    @Test
    void setTime() {
        Time expectedTime = Time.valueOf("12:59:00");
        testBookingInfo.setTime(expectedTime);
        assertEquals(expectedTime, testBookingInfo.getTime());
    }
}