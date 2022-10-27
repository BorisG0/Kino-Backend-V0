package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.BookingSQL;
import com.example.kinobackend.responses.BookingInfo;
import com.example.kinobackend.responses.Ticket;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BookingControllerTest {

    BookingController testBookingController;
    BookingSQL testBookingSQL;

    @BeforeEach
    void setUp() {
        testBookingController = new BookingController();
        testBookingSQL = new BookingSQL();
    }

    @AfterEach
    void tearDown() {
        testBookingController = null;
        testBookingSQL = null;
    }

    @Test
    void getTicketsInEventId() {
        int id = 4;
        Ticket[] actualTickets = testBookingController.getTicketsInEventId(id);
        Ticket[] expectedTickets = testBookingSQL.getTicketsForEventId(id);
        assertThat(actualTickets).usingRecursiveComparison().isEqualTo(expectedTickets);
    }

    @Test
    void getBookingsForUser() {
        String email = "lisa.schmidt@studentsDHBW.com";
        BookingInfo[] actualBookingInfo = testBookingController.getBookingsForUser(email);
        BookingInfo[] expectedBookingInfo = testBookingSQL.getBookingsForUser(email);
        assertThat(actualBookingInfo).usingRecursiveComparison().isEqualTo(expectedBookingInfo);
    }

    @Test
    void setStatusForTicket() {
    }
}