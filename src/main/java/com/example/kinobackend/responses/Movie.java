package com.example.kinobackend.responses;

public class Movie {
    private long id;
    private String name;
    private String studio;
    private int length;

    public Movie(long id, String name, String studio, int length) {
        this.id = id;
        this.name = name;
        this.studio = studio;
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
