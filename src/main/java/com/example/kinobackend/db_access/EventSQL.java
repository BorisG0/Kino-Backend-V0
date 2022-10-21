package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Event;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public final class EventSQL extends MySqlConnector {

    public Event[] getEventsForMovieId(long movieId){
        ArrayList<Event> data = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idEvent, Date, Time, room_idRoom from event where movie_idMovie = " + movieId + " order by Date");
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

    public Event[] getEventData(){
        ArrayList<Event> data = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from event");

            while(rs.next()){
                data.add(new Event(rs.getInt(1), rs.getDate(2), rs.getTime(3), rs.getInt(4), rs.getInt(5)));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Event[data.size()]);
    }

    public Event getEventById(int id){
        Event event = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from event where idEvent = " + id);
            rs.next();
            event = new Event(rs.getInt(1), rs.getDate(2), rs.getTime(3), rs.getInt(4), rs.getInt(5));
        }catch (Exception e){
            System.out.println(e);
        }
        return event;
    }


    public Event[] getEventsForMovie( int id, int days ){
        ArrayList<Event> data = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalDate limitDate = currentDate.plusDays(days);
        String currentDateString = putStringIntoApostrophe(LocalDateToString(currentDate));
        String limitDateString = putStringIntoApostrophe(LocalDateToString(limitDate));
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event " +
                    "WHERE movie_idMovie = " + id + " AND Date BETWEEN " + currentDateString + " AND " + limitDateString  );

            while(rs.next()){
                data.add(new Event(rs.getInt(1), rs.getDate(2), rs.getTime(3), rs.getInt(4), rs.getInt(5)));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Event[data.size()]);
    }

    public void addEvent( Event event){
        try {
            Statement stmt = con.createStatement();
                stmt.execute("insert into event (Date, Time, Movie_idMovie, Room_idRoom) " +
                        "values (" + putStringIntoApostrophe(JavaUtilDateToString(event.getDate())) + ", " + putStringIntoApostrophe(event.getTime().toString()) + ", "+ event.getMovieId() + ", " + event.getRoomId() +" )");
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
