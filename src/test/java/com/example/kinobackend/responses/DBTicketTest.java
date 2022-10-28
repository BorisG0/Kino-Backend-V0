package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBTicketTest {

    int idTicket = 1;
    int idSeat = 2;
    int idEvent = 3;
    int status = 4;
    int defaultPrice = 5;
    int idBooking = 6;
    DBTicket testDBTicket;

    @BeforeEach
    void setUp() {
        testDBTicket = new DBTicket(idTicket, idSeat, idEvent, status, defaultPrice, idBooking);
    }

    @AfterEach
    void tearDown() {
        testDBTicket = null;
    }

    @Test
    void getIdTicket() {
        assertEquals(idTicket, testDBTicket.getIdTicket());
    }

    @Test
    void setIdTicket() {
        int expectedIdTicket = 20;
        testDBTicket.setIdTicket(expectedIdTicket);
        assertEquals(expectedIdTicket, testDBTicket.getIdTicket());
    }

    @Test
    void getIdSeat() {
        assertEquals(idSeat, testDBTicket.getIdSeat());
    }

    @Test
    void setIdSeat() {
        int expectedIdSeat = 20;
        testDBTicket.setIdSeat(expectedIdSeat);
        assertEquals(expectedIdSeat, testDBTicket.getIdSeat());
    }

    @Test
    void getIdEvent() {
        assertEquals(idEvent, testDBTicket.getIdEvent());
    }

    @Test
    void setIdEvent() {
        int expectedIdEvent = 30;
        testDBTicket.setIdEvent(expectedIdEvent);
        assertEquals(expectedIdEvent, testDBTicket.getIdEvent());
    }

    @Test
    void getStatus() {
        assertEquals(status, testDBTicket.getStatus());
    }

    @Test
    void setStatus() {
        int expectedStatus = 40;
        testDBTicket.setStatus(expectedStatus);
        assertEquals(expectedStatus, testDBTicket.getStatus());
    }

    @Test
    void getDefaultPrice() {
        assertEquals(defaultPrice, testDBTicket.getDefaultPrice());
    }

    @Test
    void setDefaultPrice() {
        int expectedDefaultPrice = 50;
        testDBTicket.setDefaultPrice(expectedDefaultPrice);
        assertEquals(expectedDefaultPrice, testDBTicket.getDefaultPrice());
    }

    @Test
    void getIdBooking() {
        assertEquals(idBooking, testDBTicket.getIdBooking());
    }

    @Test
    void setIdBooking() {
        int expectedIdBooking = 60;
        testDBTicket.setIdBooking(expectedIdBooking);
        assertEquals(expectedIdBooking, testDBTicket.getIdBooking());
    }
}