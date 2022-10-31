package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.BookingCreation;
import com.example.kinobackend.responses.BookingInfo;
import com.example.kinobackend.responses.DBTicket;
import com.example.kinobackend.responses.Ticket;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BookingSQLTest {

    BookingSQL testBookingSQL;

    @BeforeEach
    void setUp() {
        testBookingSQL = new BookingSQL();
    }

    @AfterEach
    void tearDown() {
        testBookingSQL = null;
    }

    @Test
    void getTicketsForEventId() {
        int id = 1;
        Ticket[] actualTickets = testBookingSQL.getTicketsForEventId(id);
        Ticket[] expectedTickets = new Ticket[0];
        assertThat(actualTickets).usingRecursiveComparison().isEqualTo(expectedTickets);
    }

    @Test
    void getBookingsForUser() {
        String mail = "lisa.schmidt@studentsDHBW.com";
        BookingInfo[] actualBookingInfo = testBookingSQL.getBookingsForUser(mail);
        BookingInfo[] expectedBookingInfo = new BookingInfo[0];
        assertThat(actualBookingInfo).usingRecursiveComparison().isEqualTo(expectedBookingInfo);
    }

    @Test
    void getTicketById() {
        int id = 1;
        DBTicket actualTickets = testBookingSQL.getTicketById(id);
        DBTicket expectedTickets = new DBTicket(1, 16, 3, 0, 12, 0);
        assertThat(actualTickets).usingRecursiveComparison().isEqualTo(expectedTickets);
    }

    @Test
    void generatePDF(){
        int[] tickets = {1};
        BookingCreation bookingCreation = new BookingCreation("test@test.com", tickets);
        testBookingSQL.generatePDF(bookingCreation);
    }
}