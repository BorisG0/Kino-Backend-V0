package com.example.kinobackend.responses;

import java.sql.Time;
import java.util.Date;

public class BookingInfo {
    private int id;
    private int pricePaid;
    private String[] seatPlaces;

    private String movieTitle;
    private Date date;
    private Time time;

    public BookingInfo(int id, int pricePaid, String[] seatPlaces, String movieTitle, Date date, Time time) {
        this.id = id;
        this.pricePaid = pricePaid;
        this.seatPlaces = seatPlaces;
        this.movieTitle = movieTitle;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(int pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String[] getSeatPlaces() {
        return seatPlaces;
    }

    public void setSeatPlaces(String[] seatPlaces) {
        this.seatPlaces = seatPlaces;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
