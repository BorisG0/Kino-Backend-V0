package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.SeatSQL;
import com.example.kinobackend.responses.Event;
import com.example.kinobackend.responses.Seat;
import com.example.kinobackend.responses.SeatInEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {

    @GetMapping("/api/Seats")
    public Seat[] getSeats(){
        SeatSQL connector = new SeatSQL();
        Seat[] Seats = connector.getSeatData();
        return Seats;
    }

    @PostMapping("/api/seatsInEvent")
    public SeatInEvent[] getSeatsInEventId(@RequestBody int eventId){
        System.out.println("getting seats for eventId: " + eventId);
        SeatSQL connector = new SeatSQL();
        //SeatInEvent[] seats = connector.getSeatsForEvent(new Event(1,null,null,1,1));
        SeatInEvent[] seats = connector.getSeatsForEventId(eventId);

//        for(SeatInEvent s: seats){
//            System.out.println(s.getRow() + s.getNumberInRow() + s.getStatus());
//        }

        return seats;
    }

    @PostMapping("/api/setStatusForSeatInEvent")
    public boolean setStatusForSeatInEvent(@RequestBody SeatInEvent seatInEvent){
        System.out.println("setting status " + seatInEvent.getStatus() + " for seat with id " + seatInEvent.getSeatId() + " in event id" + seatInEvent.getEventId());
        SeatSQL connector = new SeatSQL();

        connector.setSeatInEventStatus(seatInEvent);
        return true;
    }

}
