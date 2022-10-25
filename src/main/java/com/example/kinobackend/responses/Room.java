package com.example.kinobackend.responses;

public class Room {
    private int roomId;
    public Room(){}
    public Room(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
