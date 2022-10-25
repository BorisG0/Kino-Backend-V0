package com.example.kinobackend.responses;

public class Seat {

    private long seatId;
    private  String row;
    private int seatInRow;
    private long roomId;

    public Seat(){}
    public Seat(long seatId, String row, int seatInRow, long roomId) {
        this.seatId = seatId;
        this.row = row;
        this.seatInRow = seatInRow;
        this.roomId = roomId;
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeatInRow() {
        return seatInRow;
    }

    public void setSeatInRow(int seatInRow) {
        this.seatInRow = seatInRow;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}