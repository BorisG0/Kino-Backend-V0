package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.MySqlConnector;
import com.example.kinobackend.responses.Event;
import com.example.kinobackend.responses.Movie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @PostMapping("api/eventsformovie")
    public Event[] getEventsForMovie(@RequestBody Movie movie){
        System.out.println("Getting events for movie with id: " + movie.getId());

        MySqlConnector connector = new MySqlConnector();
        Event[] events = connector.getEventsForMovieId(movie.getId());

        return events;
    }
}
