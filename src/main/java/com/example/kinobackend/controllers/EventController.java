package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.EventSQL;
import com.example.kinobackend.db_access.MySqlConnector;
import com.example.kinobackend.responses.Event;
import com.example.kinobackend.responses.EventForFrontend;
import com.example.kinobackend.responses.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @PostMapping("api/eventsformovie")
    public Event[] getEventsForMovie(@RequestBody Movie movie){
        System.out.println("Getting events for movie with id: " + movie.getId());

        EventSQL connector = new EventSQL();
        Event[] events = connector.getEventsForMovieId(movie.getId());

        return events;
    }

    @GetMapping("/api/events")
    public Event[] getEvents(){
        System.out.println("getting events");
        EventSQL connector = new EventSQL();
        Event[] events = connector.getEventData();
        return events;
    }

    @PostMapping("/api/eventById")
    public Event getEventById(@RequestBody int id){
        System.out.println("getting event by id: " + id);
        EventSQL connector = new EventSQL();
        Event event = connector.getEventById(id);
        return event;
    }

    @PostMapping("/api/movieEvents")
    public Event[] getEventsForMovie(@RequestBody int movieId){
        System.out.println("getting events for Movie");
        EventSQL connector = new EventSQL();
        Event[] events = connector.getEventsForMovie(movieId, 14);
        return events;
    }

    @PostMapping("/api/addEvent")
    public boolean addEvent(@RequestBody EventForFrontend event){
        System.out.println("test");
        EventSQL connector = new EventSQL();
        return connector.addEvent(event.getEvent());
    }

    @PostMapping("/api/updateEvent")
    public boolean updateEvent(@RequestBody EventForFrontend event){ //TODO check for existing Events like addEvent
        EventSQL connector = new EventSQL();
        return connector.updateEvent(event.getEvent());
    }
    @PostMapping("/api/setEventInactive")
    public boolean setEventInactive(@RequestBody int eventId){
        EventSQL connector = new EventSQL();
        System.out.println("set Event inactive "+ eventId);
        return connector.setEventInactive(eventId);

    }
}

