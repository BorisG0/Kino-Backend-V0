package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Seat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeatSQLTest {

    SeatSQL testSeatSQL;

    @BeforeEach
    void setUp() {
        testSeatSQL = new SeatSQL();
    }

    @AfterEach
    void tearDown() {
        testSeatSQL = null;
    }

    @Test
    void getSeatData() {
        Seat Seats[] = testSeatSQL.getSeatData();
        Seat actualSeat = Seats[9];
        Seat expectedSeat = new Seat(10, "B", 2, 1);
        assertThat(actualSeat).usingRecursiveComparison().isEqualTo(expectedSeat);
    }

}