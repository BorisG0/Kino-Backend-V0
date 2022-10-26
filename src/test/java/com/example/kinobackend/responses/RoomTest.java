package com.example.kinobackend.responses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    int roomId = 9;
    Room testRoom;

    @BeforeEach
    void setUp() {
        testRoom = new Room(roomId);
    }

    @AfterEach
    void tearDown() {
        testRoom = null;
    }

    @Test
    void getIdRoom() {
        assertEquals(roomId, testRoom.getRoomId());
    }

    @Test
    void setIdRoom() {
        int setRoomId = 10;
        testRoom.setRoomId(setRoomId);
        assertEquals(setRoomId, testRoom.getRoomId());
    }

    @Test
    void testConstructor() {
        assertEquals(roomId, testRoom.getRoomId());
    }

    @Test
    void testConstructor2(){
        testRoom = new Room();
        assertThat(new Room()).usingRecursiveComparison().isEqualTo(testRoom);
    }
}