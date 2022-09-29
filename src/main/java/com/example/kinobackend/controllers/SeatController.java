package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.SeatSQL;
import com.example.kinobackend.responses.Seat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {

    @GetMapping("/api/Seats")
    public Seat[] getSeats(){
        SeatSQL connector = new SeatSQL();
        Seat[] Seats = connector.getSeatData();
        return Seats;
    }

}
