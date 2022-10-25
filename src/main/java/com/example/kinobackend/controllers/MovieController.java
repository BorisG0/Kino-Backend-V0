package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.*;
import com.example.kinobackend.responses.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MovieController {
    @GetMapping("/api/movies")
    public Movie[] getMovies(){
        System.out.println("getting movies");
        MovieSQL connector = new MovieSQL();
        Movie[] movies = connector.getMovieData();
        return movies;
    }

    @GetMapping("/api/empMovies")
    public Movie[] getMoviesForEmployees(){
        System.out.println("getting movies for employees");
        MovieSQL connector = new MovieSQL();
        Movie[] movies = connector.getMovieDataForEmployee();
        return movies;
    }

    @PostMapping("/api/movie")
    public Movie getMovieById(@RequestBody int id){
        System.out.println("Getting Movie with id: " + id);
        MovieSQL connector = new MovieSQL();
        return connector.getMovieById(id);
    }

    @PostMapping("/api/upcmovies")
    public Movie[] getUpcomingMovies(@RequestBody int days){
        System.out.println("getting upcoming movies");
        MovieSQL connector = new MovieSQL();
        Movie[] movies = connector.getUpcomingMoviesData(days);
        return movies;
    }

    @PostMapping("/api/moviesByGenre")
    public Movie[] getMoviesByGenre(@RequestBody String genre){
        System.out.println("getting movies by Genre: " + genre);
        MovieSQL connector = new MovieSQL();
        Movie[] movies = connector.getMoviesByGenre(genre);
        return movies;
    }

    @PostMapping("/api/addMovie")
    //@GetMapping("/api/addMovie")
    public String addMovie(@RequestBody Movie movie){
    //public String addMovie(){
        MovieSQL connector = new MovieSQL();
        //Movie movie = getMovieById(1);
        connector.addMovie(movie);
        String returnString = "Movie added";
        return returnString;
    }

    @PostMapping("/api/SetMovieInactive")
    public String setMovieInactive(@RequestBody int movieId){
        MovieSQL connector = new MovieSQL();
        connector.setMovieInactive(movieId);
        return "Movie " + movieId+ " set inactive";
    }
    @PostMapping("/api/updateMovie")
    public String updateMovie(@RequestBody Movie movie){
        MovieSQL connector = new MovieSQL();
        connector.updateMovie(movie);
        return "Movie " + movie.getId()+ " updated";
    }

    @GetMapping("/api/testGetmovieById")
    public Movie testGetMovieById(){
        System.out.println("Getting Movie with id: 1" );
        MovieSQL connector = new MovieSQL();
        return connector.getMovieById(1);
    }
    }
