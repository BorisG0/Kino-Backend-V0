package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Customer;
import com.example.kinobackend.responses.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoomSQLTest {

    RoomSQL testRoomSQL;

    @BeforeEach
    void setUp() {
        testRoomSQL = new RoomSQL();
    }

    @AfterEach
    void tearDown() {
        testRoomSQL = null;
    }

    @Test
    void getRoomData() {
        Room Rooms[] = testRoomSQL.getRoomData();
        Room actualRoom = Rooms[1];
        Room expectedRoom = new Room(2);
        assertThat(actualRoom).usingRecursiveComparison().isEqualTo(expectedRoom);
    }
}