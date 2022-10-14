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


    @PostMapping("/api/addMovies")
    public String addMovies(@RequestBody Movie[]movies){
        MovieSQL connector = new MovieSQL();
        connector.addMovies(movies);
        String returnString = "";
        for (Movie movie:movies) {
            String movieAdded = "Movie added" + connector.getMovieById((int)movie.getId());
            returnString+=movieAdded;
        }
        return returnString;
    }
    @PostMapping("/api/addMovie")
    public String addMovie(@RequestBody Movie movie){
        MovieSQL connector = new MovieSQL();
        connector.addMovie(movie);
        String returnString = "Movie added" + connector.getMovieById((int)movie.getId());
        return returnString;
    }

}
