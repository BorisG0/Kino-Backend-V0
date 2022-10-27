package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.MovieSQL;
import com.example.kinobackend.responses.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieControllerTest {

    MovieController testMovieController;
    MovieSQL testMovieSQL;

    @BeforeEach
    void setUp() {
        testMovieController = new MovieController();
        testMovieSQL = new MovieSQL();
    }

    @AfterEach
    void tearDown() {
        testMovieController = null;
        testMovieSQL = null;
    }

    @Test
    void getMovies() {
        Movie[] actualMovies = testMovieController.getMovies();
        Movie[] expectedMovies = testMovieSQL.getMovieData();
        assertThat(actualMovies).usingRecursiveComparison().isEqualTo(expectedMovies);
    }

    @Test
    void getMoviesForEmployees() {
        Movie[] actualMovies = testMovieController.getMoviesForEmployees();
        Movie[] expectedMovies = testMovieSQL.getMovieDataForEmployee();
        assertThat(actualMovies).usingRecursiveComparison().isEqualTo(expectedMovies);
    }

    @Test
    void getMovieById() {
        int id = 2;
        Movie actualMovie = testMovieController.getMovieById(id);
        Movie expectedMovie = testMovieSQL.getMovieById(id);
        assertThat(actualMovie).usingRecursiveComparison().isEqualTo(expectedMovie);
    }

    @Test
    void getUpcomingMovies() {
        int days = 7;
        Movie[] actualMovies = testMovieController.getUpcomingMovies(days);
        Movie[] expectedMovies = testMovieSQL.getUpcomingMoviesData(days);
        assertThat(actualMovies).usingRecursiveComparison().isEqualTo(expectedMovies);
    }

    @Test
    void getMoviesByGenre() {
        String genre = "Action";
        Movie[] actualMovies = testMovieController.getMoviesByGenre(genre);
        Movie[] expectedMovies = testMovieSQL.getMoviesByGenre(genre);
        assertThat(actualMovies).usingRecursiveComparison().isEqualTo(expectedMovies);
    }

    @Test
    void testGetMovieById() {
        int id = 1;
        Movie actualMovie = testMovieController.getMovieById(id);
        Movie expectedMovie = testMovieSQL.getMovieById(id);
        assertThat(actualMovie).usingRecursiveComparison().isEqualTo(expectedMovie);
    }
}