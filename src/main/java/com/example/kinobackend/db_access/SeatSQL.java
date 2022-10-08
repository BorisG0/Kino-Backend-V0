package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Seat;
import com.example.kinobackend.responses.SeatInEvent;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public final class SeatSQL extends MySqlConnector {

    public Seat[] getSeatData(){
        ArrayList<Seat> data = new ArrayList<Seat>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from seat");

            while(rs.next()){
                data.add(new Seat(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getLong(4)));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return data.toArray(new Seat[0]);
    }

    public SeatInEvent[] getSeatsForEventId(int eventId){
        ArrayList<SeatInEvent> data = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select s.Line, s.NumberInLine, sie.status, sie.seat_idSeat, sie.event_idEvent " +
                    "from seats_in_event sie, seat s where sie.seat_idSeat = s.idSeat and sie.event_idEvent = "
                    + eventId);

            while(rs.next()){
                data.add(new SeatInEvent(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }

        }catch(Exception e){
            System.out.println(e);
        }

        return data.toArray(new SeatInEvent[0]);
    }

    public void setSeatInEventStatus(SeatInEvent seatInEvent){
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE seats_in_event SET Status = " + seatInEvent.getStatus()
                    + " WHERE (event_idEvent = " + seatInEvent.getEventId() + ") and (seat_idSeat = " + seatInEvent.getSeatId() + ")");

        }catch(Exception e){
            System.out.println(e);
        }
    }

}
