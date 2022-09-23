package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Event;
import com.example.kinobackend.responses.Movie;
import com.example.kinobackend.responses.Customer;
import com.example.kinobackend.responses.Room;

import java.sql.*;
import java.util.ArrayList;

public class MySqlConnector {
    Connection con;
    public MySqlConnector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public Event[] getEventsForMovieId(long movieId){
        ArrayList<Event> data = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select e.idEvent, e.Date, e.Time, e.Rooms_idRoom from Movies m, Events e " +
                                                    "where m.idMovie = e.Movies_idMovie and m.idMovie = " + movieId);

            while(rs.next()){
                Event e = new Event(rs.getInt(1), rs.getDate(2), rs.getTime(3), movieId, rs.getInt(4));
                System.out.println(e);
                data.add(e);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return data.toArray(new Event[0]);
    }

    public Movie[] getMovieData(){
        ArrayList<Movie> data = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from movies");

            while(rs.next()){
                data.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Movie[0]);
    }

    public Movie getMovieById(int id){
        Movie movie = null;

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from movies where idMovie = " + id);
            rs.next();
            movie = new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4));
        }catch(Exception e){
            System.out.println(e);
        }

        return movie;
    }

    public Customer[] getCustomerData(){
        ArrayList<Customer> data = new ArrayList<Customer>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customers");

            while(rs.next()){
                data.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return data.toArray(new Customer[0]);
    }

    public Room[] getRoomData(){
        ArrayList<Room> data = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idRoom from rooms");

            while(rs.next()){
                data.add(new Room(rs.getInt(1)));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Room[0]);
    }

    public Event[] getEventData(){
        ArrayList<Event> data = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from events");

            while(rs.next()){
                data.add(new Event(rs.getInt(1), rs.getDate(2), rs.getTime(3), rs.getInt(4), rs.getInt(5)));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Event[data.size()]);
    }
}
