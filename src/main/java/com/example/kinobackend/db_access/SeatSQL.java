package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Seat;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public final class SeatSQL extends MySqlConnector {

    public Seat[] getSeatData(){
        ArrayList<Seat> data = new ArrayList<Seat>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from seats");

            while(rs.next()){
                data.add(new Seat(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getLong(4)));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return data.toArray(new Seat[0]);
    }

}
