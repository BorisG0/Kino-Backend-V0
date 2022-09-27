package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class MySqlConnector {
    Connection con;
    public MySqlConnector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "DBADMIN");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public Event[] getEventsForMovieId(long movieId){
        ArrayList<Event> data = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select e.idEvent, e.Date, e.Time, e.rooms_idRoom from Movies m, Events e " +
                                                    "where m.idMovie = e.movies_idMovie and m.idMovie = " + movieId);

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
                data.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8)));
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
            movie = new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8));
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

    public Movie[] getUpcomingMoviesData( int days ){
        ArrayList<Movie> data = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalDate limitDate = currentDate.plusDays(days);
        String currentDateString = putStringIntoApostrophe(LocalDateToString(currentDate));
        String limitDateString = putStringIntoApostrophe(LocalDateToString(limitDate));
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT movies.idMovie, movies.Title, movies.Duration, movies.AgeRestriction " +
                    "FROM movies inner join events ON movies.idMovie = events.movies_idMovie " +
                    "WHERE events.Date BETWEEN " + currentDateString + " and " + limitDateString );

            while(rs.next()){
                data.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8)));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Movie[data.size()]);
    }
    public Event[] getEventsForMovie( int id, int days ){
        ArrayList<Event> data = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalDate limitDate = currentDate.plusDays(days);
        String currentDateString = putStringIntoApostrophe(LocalDateToString(currentDate));
        String limitDateString = putStringIntoApostrophe(LocalDateToString(limitDate));
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM events " +
                    "WHERE movies_idMovie = " + id + " AND Date BETWEEN " + currentDateString + " AND " + limitDateString  );

            while(rs.next()){
                data.add(new Event(rs.getInt(1), rs.getDate(2), rs.getTime(3), rs.getInt(4), rs.getInt(5)));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Event[data.size()]);
    }

    public Movie[] getMoviesByGenre( String genre){
        ArrayList<Movie> data = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from movies where genre like "+ prepareStringForLikeOperation(genre));

            while(rs.next()){
                data.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8)));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Movie[0]);
    }

    public String putStringIntoApostrophe(String string){
        String outputString = "'"+string+"'";
        return outputString;
    }
    public String prepareStringForLikeOperation(String string){
        String outputString = "'%"+string+"%'";
        return outputString;
    }

    public String LocalDateToString(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = date.format(formatter) ;
        return dateString;
    }

    public String JavaUtilDateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String dateString = dateFormat.format(date) ;
        return dateString;
    }
    public Seat[] getSeatData(){
        ArrayList<Seat> data = new ArrayList<Seat>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from seats");

            while(rs.next()){
                data.add(new Seat(rs.getInt(1), rs.getBoolean(2), rs.getBigDecimal(3), rs.getShort(4), rs.getInt(5)));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return data.toArray(new Seat[0]);
    }

    public void addMovies(Movie[] movies){
        try {
            Statement stmt = con.createStatement();
            for (Movie movie : movies) {
                stmt.execute("INSERT INTO movies (`idMovie`, `Title`, `Duration`, AgeRestriction) " +
                        "VALUES   (" + movie.getId() + ", "+ putStringIntoApostrophe(movie.getTitle()) + ", " + movie.getDuration() + ", "+ movie.getAgeRestriction() +" )");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void addEvents( Event[]events){
        try {
            Statement stmt = con.createStatement();
            for (Event event : events) {
                stmt.execute("insert into events (idEvent, Date, Time, Movies_idMovie, Rooms_idRoom) " +
                        "values (" + event.getId() + ", "+ putStringIntoApostrophe(JavaUtilDateToString(event.getDate())) + ", " + putStringIntoApostrophe(event.getTime().toString()) + ", "+ event.getMovieId() + ", " + event.getRoomId() +" )");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
