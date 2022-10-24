package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.BookingSQL;
import com.example.kinobackend.db_access.SeatSQL;
import com.example.kinobackend.responses.BookingCreation;
import com.example.kinobackend.responses.SeatInEvent;
import com.example.kinobackend.responses.StatusChange;
import com.example.kinobackend.responses.Ticket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
public class BookingController {
    @PostMapping("/api/newBooking")
    public boolean newBooking(@RequestBody BookingCreation bookingCreation){
        System.out.println("new booking creation:  customer=" + bookingCreation.getEmail() + " tickets=" + bookingCreation.getTicketIds().length);
        BookingSQL bookingSQL = new BookingSQL();

        int bookingId = bookingSQL.addBooking(bookingCreation.getEmail(), 100);

        for(int id: bookingCreation.getTicketIds()){
            bookingSQL.setStatusForTicket(new StatusChange(id, 1), bookingId);
        }





        return true;
    }

    @PostMapping("/api/ticketsInEvent")
    public Ticket[] getTicketsInEventId(@RequestBody int eventId){
        System.out.println("getting tickets for eventId: " + eventId);
        BookingSQL connector = new BookingSQL();


        Ticket[] tickets = connector.getTicketsForEventId(eventId);


        return tickets;
    }


    @PostMapping("/api/setStatusForTicket")
    public boolean setStatusForTicket(@RequestBody StatusChange statusChange){
        System.out.println("setting status " + statusChange.getStatus() + " for ticket with id " + statusChange.getStatus());
        BookingSQL connector = new BookingSQL();

        connector.setStatusForTicket(statusChange, 0);
        return true;
    }


}
