package com.example.kinobackend.responses;

public class BookingInfo {
    private int id;
    private int pricePaid;
    private String[] seatPlaces;

    public BookingInfo(int id, int pricePaid, String[] seatPlaces) {
        this.id = id;
        this.pricePaid = pricePaid;
        this.seatPlaces = seatPlaces;
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
}
