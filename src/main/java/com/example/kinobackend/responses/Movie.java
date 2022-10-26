package com.example.kinobackend.responses;

import java.util.Date;

public class Movie {
    private long id;
    private String title;
    private int duration;
    private int ageRestriction;
    private String imageName;
    private String description;
    private String genre;
    private Date startDate;
    private String movieStudio;
    private String regie;
    private String cast;
    private String trailerLink;
    private boolean active;

    public Movie(){}
    public Movie(long id, String title, int duration, int ageRestriction, String imageName, String description, String genre, Date startDate, String movieStudio, String regie, String cast, String trailerLink, boolean active) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.ageRestriction = ageRestriction;
        this.imageName = imageName;
        this.description = description;
        this.genre = genre;
        this.startDate = startDate;
        this.movieStudio = movieStudio;
        this.regie = regie;
        this.cast = cast;
        this.trailerLink = trailerLink;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getMovieStudio() {
        return movieStudio;
    }

    public void setMovieStudio(String movieStudio) {
        this.movieStudio = movieStudio;
    }

    public String getRegie() {
        return regie;
    }

    public void setRegie(String regie) {
        this.regie = regie;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
