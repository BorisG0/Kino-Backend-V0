package com.example.kinobackend.db_access;

import java.sql.Statement;

public class BookingSQL extends MySqlConnector{
    public void addBooking(int bookingId, String email, int pricePaid){
        try {
            Statement stmt = con.createStatement();
            stmt.execute("");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
