package com.example.kinobackend.responses;

public class SeatInEvent {
    private String row;
    private int numberInRow;
    private int status;
    private int seatId;
    private int eventId;

    public SeatInEvent(){

    }

    public SeatInEvent(String row, int numberInRow, int status) {
        this.row = row;
        this.numberInRow = numberInRow;
        this.status = status;
    }

    public SeatInEvent(String row, int numberInRow, int status, int seatId, int eventId) {
        this.row = row;
        this.numberInRow = numberInRow;
        this.status = status;
        this.seatId = seatId;
        this.eventId = eventId;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getNumberInRow() {
        return numberInRow;
    }

    public void setNumberInRow(int numberInRow) {
        this.numberInRow = numberInRow;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
