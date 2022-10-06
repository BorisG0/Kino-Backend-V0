package com.example.kinobackend.responses;

public class SeatInEvent {
    private String row;
    private int numberInRow;
    private int status;

    public SeatInEvent(String row, int numberInRow, int status) {
        this.row = row;
        this.numberInRow = numberInRow;
        this.status = status;
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
}
