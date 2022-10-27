package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    long id = 32;
    String title = "Minions";
    int duration = 120;
    int ageRestriction = 6;
    String imageName = "minions.png";
    String description = "Die Minions sind gelb.";
    String genre = "Kinderfilm";
    Date startDate = new Date(20221101);
    String movieStudio = "neues Studio";
    String regie = "Regisseur";
    String cast = "Hier, stehen, mehrere, Schauspieler";
    String trailerLink = "link.de";
    Movie testMovie;
    boolean active = true;

    @BeforeEach
    void setUp() {
        testMovie = new Movie(id, title, duration, ageRestriction, imageName, description, genre, startDate, movieStudio, regie, cast, trailerLink, active);
    }

    @AfterEach
    void tearDown() {
        testMovie = null;
    }

    @Test
    void getId() {
        assertEquals(id, testMovie.getId());
    }

    @Test
    void setId() {
        long setId = 100;
        testMovie.setId(setId);
        assertEquals(setId, testMovie.getId());
    }

    @Test
    void getTitle() {
        assertEquals(title, testMovie.getTitle());
    }

    @Test
    void setTitle() {
        String setTitle = "Neuer Film";
        testMovie.setTitle(setTitle);
        assertEquals(setTitle, testMovie.getTitle());
    }

    @Test
    void getDuration() {
        assertEquals(duration, testMovie.getDuration());
    }

    @Test
    void setDuration() {
        int setDuration = 999;
        testMovie.setDuration(setDuration);
        assertEquals(setDuration, testMovie.getDuration());
    }

    @Test
    void getAgeRestriction() {
        assertEquals(ageRestriction, testMovie.getAgeRestriction());
    }

    @Test
    void setAgeRestriction() {
        int setAgeRestriction = 0;
        testMovie.setAgeRestriction(setAgeRestriction);
        assertEquals(setAgeRestriction, testMovie.getAgeRestriction());
    }

    @Test
    void getImageName() {
        assertEquals(imageName, testMovie.getImageName());
    }

    @Test
    void setImageName() {
        String setImageName = "neuesBild.png";
        testMovie.setImageName(setImageName);
        assertEquals(setImageName, testMovie.getImageName());
    }

    @Test
    void getDescription() {
        assertEquals(description, testMovie.getDescription());
    }

    @Test
    void setDescription() {
        String setDescription = "Das ist die Beschreibung des neuen Films";
        testMovie.setDescription(setDescription);
        assertEquals(setDescription, testMovie.getDescription());
    }

    @Test
    void getGenre() {
        assertEquals(genre, testMovie.getGenre());
    }

    @Test
    void setGenre() {
        String setGenre = "Familienfilm";
        testMovie.setGenre(setGenre);
        assertEquals(setGenre, testMovie.getGenre());
    }

    @Test
    void getStartDate() {
        assertEquals(startDate, testMovie.getStartDate());
    }

    @Test
    void setStartDate() {
        Date setStartDate = new Date(20230101);
        testMovie.setStartDate(setStartDate);
        assertEquals(setStartDate, testMovie.getStartDate());
    }

    @Test
    void getMovieStudio() {
        assertEquals(movieStudio, testMovie.getMovieStudio());
    }

    @Test
    void setMovieStudio() {
        String setMovieStudio = "Hier das Studio";
        testMovie.setMovieStudio(setMovieStudio);
        assertEquals(setMovieStudio, testMovie.getMovieStudio());
    }

    @Test
    void getRegie() {
        assertEquals(regie, testMovie.getRegie());
    }

    @Test
    void setRegie() {
        String setRegie = "NeuerRegisseur";
        testMovie.setRegie(setRegie);
        assertEquals(setRegie, testMovie.getRegie());
    }

    @Test
    void getCast() {
        assertEquals(cast, testMovie.getCast());
    }

    @Test
    void setCast() {
        String setCast = "Schauspieler 1, 2, 3";
        testMovie.setCast(setCast);
        assertEquals(setCast, testMovie.getCast());
    }

    @Test
    void getTrailerLink() {
        assertEquals(trailerLink, testMovie.getTrailerLink());
    }

    @Test
    void setTrailerLink() {
        String setTrailerLink = "neuerLink.de";
        testMovie.setTrailerLink(setTrailerLink);
        assertEquals(setTrailerLink, testMovie.getTrailerLink());
    }

    @Test
    void isActive(){
        assertEquals(active, testMovie.isActive());
    }

    @Test
    void setActive(){
        boolean expectedActive = false;
        testMovie.setActive(expectedActive);
        assertEquals(expectedActive, testMovie.isActive());
    }

    @Test
    void testConstructor() {
        assertEquals(id, testMovie.getId());
        assertEquals(title, testMovie.getTitle());
        assertEquals(duration, testMovie.getDuration());
        assertEquals(ageRestriction, testMovie.getAgeRestriction());
       // assertEquals(imageName, testMovie.getImage());
        assertEquals(description, testMovie.getDescription());
        assertEquals(genre, testMovie.getGenre());
        assertEquals(startDate, testMovie.getStartDate());
        assertEquals(movieStudio, testMovie.getMovieStudio());
        assertEquals(regie, testMovie.getRegie());
        assertEquals(cast, testMovie.getCast());
        assertEquals(trailerLink, testMovie.getTrailerLink());
    }

    @Test
    void testConstructor2(){
        testMovie = new Movie();
        assertThat(new Movie()).usingRecursiveComparison().isEqualTo(testMovie);
    }
}