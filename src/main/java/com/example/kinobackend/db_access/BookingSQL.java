package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.BookingCreation;
import com.example.kinobackend.responses.StatusChange;
import com.example.kinobackend.responses.Ticket;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class BookingSQL extends MySqlConnector{
    public void addBooking(int bookingId, String email, int pricePaid){
        try {
            Statement stmt = con.createStatement();
            stmt.execute("");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Ticket[] getTicketsForEventId(int id){
        ArrayList<Ticket> data = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select t.idTicket, s.Line, s.NumberInLine, t.status, " +
                    "t.defaultPrice from ticket t, seat s where t.idSeat = s.idSeat and idEvent = " + id);

            while(rs.next()){
                Ticket t = new Ticket(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5));
                data.add(t);
            }

        }catch(Exception e){
            System.out.println(e);
        }

        return data.toArray(new Ticket[0]);
    }

    public void setStatusForTicket(StatusChange statusChange){
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE ticket SET status = " + statusChange.getStatus() + " WHERE (idTicket = " + statusChange.getId() + ")");

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
