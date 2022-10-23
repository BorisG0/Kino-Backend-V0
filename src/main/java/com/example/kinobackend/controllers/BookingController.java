package com.example.kinobackend.controllers;

import com.example.kinobackend.responses.BookingCreation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @PostMapping("/api/newBooking")
    public boolean newBooking(@RequestBody BookingCreation bookingCreation){
        System.out.println("new booking creation:  customerId=" + bookingCreation.getCustomerId() + " tickets=" + bookingCreation.getTicketIds().length);

        return true;
    }
}
