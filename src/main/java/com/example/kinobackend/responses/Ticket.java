package com.example.kinobackend.responses;

public class Ticket {
    private int id;
    private String row;
    private int numberInRow;
    private int status;
    private int defaultPrice;

    public Ticket(int id, String row, int numberInRow, int status, int defaultPrice) {
        this.id = id;
        this.row = row;
        this.numberInRow = numberInRow;
        this.status = status;
        this.defaultPrice = defaultPrice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(int defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String toString(){
        return "Ticket: " + id + " " + status;
    }
}
