package com.example.kinobackend.responses;
import java.math.BigDecimal;
public class Seat {

    private int seatId;

    private boolean isFree;

    private BigDecimal Price;

    private char row;

    private int number;

    public Seat(int seatId, boolean isFree, BigDecimal price, short row, int number) {
        this.seatId = seatId;
        this.isFree = isFree;
        Price = price;
        this.row = (char) row;
        this.number = number;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
