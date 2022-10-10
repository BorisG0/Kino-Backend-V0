package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieSQLTest {

    MovieSQL testMovieSQL;
    //Connection con;

    @BeforeEach
    void setUp() {
        testMovieSQL = new MovieSQL();
    }

    @AfterEach
    void tearDown() {
        testMovieSQL = null;
    }

    @Test
    void getMovieData() {
    }

    @Test
    void getMovieById() throws ParseException {
        String date_string = "30-06-2022";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(date_string);

        Movie expectedMovie = new Movie(1, "Minions: Auf der Suche nach dem Mini-Boss", 88, 6, "img0.png", "Als Fan der Superschurkengruppe Vicious 6 heckt Gru einen Plan aus, um böse genug zu werden, um sich ihnen anzuschließen, und wird dabei von seinen Anhängern, den Minions, unterstützt.", " Animation, Abenteuer, Komödie, Fantasy ", date,"Universal Pictures Studio & Illumination Entertainment","Kyle Balda","Steve Carell, Pierre Coffin, Alan Arkin","\"https://www.youtube.com/embed/6DxjJzmYsXo\"");
        Movie actualMovie = testMovieSQL.getMovieById((int) expectedMovie.getId());

        assertThat(actualMovie).usingRecursiveComparison().isEqualTo(expectedMovie);
    }

    @Test
    void getUpcomingMoviesData() {
    }

    @Test
    void getMoviesByGenre() {
    }

    @Test
    void addMovies() {
    }
}