package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Room;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public final class RoomSQL extends MySqlConnector {

    public Room[] getRoomData(){
        ArrayList<Room> data = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idRoom from room");

            while(rs.next()){
                data.add(new Room(rs.getInt(1)));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Room[0]);
    }
}
