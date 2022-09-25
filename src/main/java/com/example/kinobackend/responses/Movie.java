package com.example.kinobackend.responses;

public class Movie {
    private long id;
    private String title;
    private int duration;
    private int ageRestriction;
    private String imageName;

    public Movie(long id, String title, int duration, int ageRestriction, String imageName) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.ageRestriction = ageRestriction;
        this.imageName = imageName;
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
}
