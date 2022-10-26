package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Event;
import com.example.kinobackend.responses.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public final class EventSQL extends MySqlConnector {

    public Event[] getEventsForMovieId(long movieId){
        ArrayList<Event> data = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idEvent, Date, Time, room_idRoom from event where movie_idMovie = " + movieId + " order by Date");
            while(rs.next()){
                Event e = new Event(rs.getInt(1), rs.getDate(2), rs.getTime(3), movieId, rs.getInt(4));
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

    public String addEvent( Event event){
        try {
            MovieSQL movieSQL = new MovieSQL();
            Movie movieForAddedEvent = movieSQL.getMovieById((int)event.getMovieId());
            int movieDuration = movieForAddedEvent.getDuration();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Time, movie_idMovie, idEvent from event where Date = "+putStringIntoApostrophe(JavaUtilDateToString(event.getDate())) + "and room_idRoom = "+event.getRoomId());
            while (rs.next()){
                if (rs.getTime(1).toLocalTime().isAfter(event.getTime().toLocalTime())){
                    LocalTime endTime = event.getTime().toLocalTime().plusMinutes(movieDuration);
                    if (endTime.isAfter(rs.getTime(1).toLocalTime())){
                        return "Room is already occupied at timeslot with event: "+rs.getInt(3);
                    }
                }
                else{
                    Movie movieFromExistingEvent = movieSQL.getMovieById(rs.getInt(2));
                    LocalTime endTimeOfExistingEvent = rs.getTime(1).toLocalTime().plusMinutes(movieFromExistingEvent.getDuration());
                    if (endTimeOfExistingEvent.isAfter(event.getTime().toLocalTime())){
                        return "Room is already occupied at timeslot with event: "+rs.getInt(3);
                    }
                }
            }
                stmt.execute("insert into event (Date, Time, Movie_idMovie, Room_idRoom) " +
                        "values (" + putStringIntoApostrophe(JavaUtilDateToString(event.getDate()))
                        + ", " + putStringIntoApostrophe(event.getTime().toString())
                        + ", "+ event.getMovieId()
                        + ", " + event.getRoomId() +" )");
            Event addedEvent = getEventByDateTimeRoom(event.getDate(),event.getTime(),event.getRoomId());
            System.out.println(addedEvent);
            generateTicketsForEvent(addedEvent);
        }catch (Exception e){
            System.out.println(e);
        }
        return "Event successfully added";
    }
    public void updateEvent(Event event){
        try {
            Statement stmt = con.createStatement();
            stmt.execute("update event set Date = "+putStringIntoApostrophe(JavaUtilDateToString(event.getDate()))+", Time = "+putStringIntoApostrophe(event.getTime().toString())+", Movie_idMovie = "+event.getMovieId()+", Room_idRoom = "+event.getRoomId()+" where idEvent = "+event.getId());
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void generateTicketsForEvent(Event event){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idSeat from seat where room_idRoom = "+event.getRoomId());
            while (rs.next()){
                stmt.executeQuery("insert into ticket (idSeat. idEvent, status, defaultPrice)"
                                    +"values("+rs.getInt(1)+", "+event.getId()+", 0, 12)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Event getEventByDateTimeRoom(Date date, Time time, long roomId){
        Event event = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from event where Date = " + putStringIntoApostrophe(JavaUtilDateToString(date))
                                                +" and Time = "+putStringIntoApostrophe(date.toString())
                                                +" and room_idRoom = "+roomId);
            rs.next();
            event = new Event(rs.getInt(1), rs.getDate(2), rs.getTime(3), rs.getInt(4), rs.getInt(5));
        }catch (Exception e){
            System.out.println(e);
        }
        return event;
    }

    public int getFreeSeatsForEvent(long eventId){
        int freeSeats=0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(status) from ticket where idEvent = "+ eventId + " and status = 0");
            rs.next();
            freeSeats = rs.getInt(1);
        }catch (Exception e){
            System.out.println(e);
        }
        return freeSeats;
    }
}
