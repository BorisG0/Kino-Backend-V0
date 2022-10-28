package com.example.kinobackend.responses;

public class DBTicket {
    private int idTicket;
    private int idSeat;
    private int idEvent;
    private int status;
    private int defaultPrice;
    private int idBooking;

    public DBTicket(int idTicket, int idSeat, int idEvent, int status, int defaultPrice, int idBooking) {
        this.idTicket = idTicket;
        this.idSeat = idSeat;
        this.idEvent = idEvent;
        this.status = status;
        this.defaultPrice = defaultPrice;
        this.idBooking = idBooking;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(int defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }
}
