package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Movie;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public final class MovieSQL extends MySqlConnector{

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


}
