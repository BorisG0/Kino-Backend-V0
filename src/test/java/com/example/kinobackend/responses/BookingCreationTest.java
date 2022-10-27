package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingCreationTest {

    String email = "test@neueMail.de";
    int[] ticketIds = {23, 32, 12, 21};
    BookingCreation testBookingCreation;

    @BeforeEach
    void setUp() {
        testBookingCreation = new BookingCreation(email, ticketIds);
    }

    @AfterEach
    void tearDown() {
        testBookingCreation = null;
    }

    @Test
    void getEmail() {
        assertEquals(email, testBookingCreation.getEmail());
    }

    @Test
    void setEmail() {
        String expectedMail = "neue.test@mail.de";
        testBookingCreation.setEmail(expectedMail);
        assertEquals(expectedMail, testBookingCreation.getEmail());
    }

    @Test
    void getTicketIds() {
        assertEquals(ticketIds, testBookingCreation.getTicketIds());
    }

    @Test
    void setTicketIds() {
        int[] expectedTicketIds = {45, 54, 65, 56};
        testBookingCreation.setTicketIds(expectedTicketIds);
        assertEquals(expectedTicketIds, testBookingCreation.getTicketIds());
    }
}