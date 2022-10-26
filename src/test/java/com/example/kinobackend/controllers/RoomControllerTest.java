package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.RoomSQL;
import com.example.kinobackend.responses.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoomControllerTest {

    RoomController testRoomController;
    RoomSQL testRoomSQL;

    @BeforeEach
    void setUp() {
        testRoomController = new RoomController();
        testRoomSQL = new RoomSQL();
    }

    @AfterEach
    void tearDown() {
        testRoomController = null;
        testRoomSQL = null;
    }

    @Test
    void getRooms() {
        Room[] actualRooms = testRoomController.getRooms();
        Room[] expectedRooms = testRoomSQL.getRoomData();
        assertThat(expectedRooms).usingRecursiveComparison().isEqualTo(actualRooms);
    }
}