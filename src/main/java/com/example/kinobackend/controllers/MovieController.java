package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.MySqlConnector;
import com.example.kinobackend.responses.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

@RestController
public class MovieController {
    @GetMapping("/api/movies")
    public Movie[] getMovies(){
        System.out.println("getting movies");
        MySqlConnector connector = new MySqlConnector();
        Movie[] movies = connector.getMovieData();
        return movies;
    }

    @PostMapping("/api/movie")
    public Movie getMovieById(@RequestBody int id){
        System.out.println("Getting Movie with id: " + id);
        MySqlConnector connector = new MySqlConnector();
        return connector.getMovieById(id);
    }

    @GetMapping("/api/customers")
    public Customer[] getCustomers(){
        System.out.println("getting customers");
        MySqlConnector connector = new MySqlConnector();
        Customer[] customers = connector.getCustomerData();
        return customers;
    }

    @GetMapping("/api/rooms")
    public Room[] getRooms(){
        System.out.println("getting rooms");
        MySqlConnector connector = new MySqlConnector();
        Room[] rooms = connector.getRoomData();
        return rooms;
    }

    @GetMapping("/api/events")
    public Event[] getEvents(){
        System.out.println("getting events");
        MySqlConnector connector = new MySqlConnector();
        Event[] events = connector.getEventData();
        return events;
    }

    @PostMapping("/api/upcmovies")
    public Movie[] getUpcomingMovies(@RequestBody int days){
        System.out.println("getting upcoming movies");
        MySqlConnector connector = new MySqlConnector();
        Movie[] movies = connector.getUpcomingMoviesData(days);
        return movies;
    }

    @PostMapping("/api/moviesByGenre")
    public Movie[] getMoviesByGenre(@RequestBody String genre){
        System.out.println("getting movies by Genre");
        MySqlConnector connector = new MySqlConnector();
        Movie[] movies = connector.getMoviesByGenre(genre);
        return movies;
    }

    @PostMapping("/api/movieEvents")
    public Event[] getEventsForMovie(@RequestBody int movieId, int days){
        System.out.println("getting events for Movie");
        MySqlConnector connector = new MySqlConnector();
        Event[] events = connector.getEventsForMovie(movieId, days);
        return events;
    }

    @GetMapping("/api/Seats")
    public Seat[] getSeats(){
        MySqlConnector connector = new MySqlConnector();
        Seat[] Seats = connector.getSeatData();
        return Seats;
    }

    @PostMapping("/api/addMovies")
    public String addMovies(@RequestBody Movie[]movies){
        MySqlConnector connector = new MySqlConnector();
        connector.addMovies(movies);
        String returnString = "";
        for (Movie movie:movies) {
            String movieAdded = "Movie added" + connector.getMovieById((int)movie.getId());
            returnString+=movieAdded;
        }
        return returnString;
    }

    @PostMapping("/api/addEvents")
    public String addEvents(@RequestBody Event[] events){
        MySqlConnector connector = new MySqlConnector();
        connector.addEvents(events);
        String returnString = "";
        for (Event event:events) {
            String eventAdded = "Event added" + connector.getEventsForMovieId((int)event.getId());
            returnString+=eventAdded;
        }
        return returnString;
    }
}
