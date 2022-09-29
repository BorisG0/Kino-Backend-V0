package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

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
    Movie testMovie;

    @BeforeEach
    void setUp() {
        testMovie = new Movie(id, title, duration, ageRestriction, imageName, description, genre, startDate);
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
    void testConstructor() {
        assertEquals(id, testMovie.getId());
        assertEquals(title, testMovie.getTitle());
        assertEquals(duration, testMovie.getDuration());
        assertEquals(ageRestriction, testMovie.getAgeRestriction());
        assertEquals(imageName, testMovie.getImageName());
        assertEquals(description, testMovie.getDescription());
        assertEquals(genre, testMovie.getGenre());
        assertEquals(startDate, testMovie.getStartDate());
    }
}