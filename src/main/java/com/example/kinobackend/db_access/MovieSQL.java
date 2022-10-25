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
            ResultSet rs = stmt.executeQuery("select * from movie where active = true");

            while(rs.next()){
                data.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12)));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Movie[0]);
    }

    public Movie[] getMovieDataForEmployee(){
        ArrayList<Movie> data = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from movie");

            while(rs.next()){
                data.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12)));
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
            ResultSet rs = stmt.executeQuery("select * from movie where idMovie = " + id+ " and active = true");
            rs.next();
            movie = new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3),
                    rs.getInt(4), rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getDate(8), rs.getString(9),
                    rs.getString(10), rs.getString(11), rs.getString(12));
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
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT movie.idMovie, movie.Title, movie.Duration, " +
                    "movie.AgeRestriction, movie.imageName, movie.Description, movie.Genre, movie,StartDate, " +
                    "movie.movieStudio, movie.regie, movie.cast, movie.trailerLink " +
                    "FROM movie inner join event ON movie.idMovie = event.movie_idMovie " +
                    "WHERE event.Date BETWEEN " + currentDateString + " and " + limitDateString +" and active = true");

            while(rs.next()){
                data.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getDate(8), rs.getString(9), rs.getString(10),
                        rs.getString(11), rs.getString(12)));
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
            ResultSet rs = stmt.executeQuery("select * from movie where genre like "
                    + prepareStringForLikeOperation(genre)+" and active = true");

            while(rs.next()){
                data.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getString(5) , rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12)));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return data.toArray(new Movie[0]);
    }

    public void addMovie(Movie movie){
        try {
            Statement stmt = con.createStatement();
                stmt.execute("INSERT INTO movie (Title, Duration, AgeRestriction, imageName, Description, Genre, " +
                        "StartDate, movieStudio, regie, cast, trailerLink, active) " + "VALUES   ("
                        + putStringIntoApostrophe(movie.getTitle()) + ", " + movie.getDuration() + ", "
                        + movie.getAgeRestriction() +", "+putStringIntoApostrophe(movie.getImageName()) + ", "
                        +putStringIntoApostrophe(movie.getDescription())+", "+putStringIntoApostrophe(movie.getGenre())
                        +", "+putStringIntoApostrophe(JavaUtilDateToString(movie.getStartDate()))+", "
                        +putStringIntoApostrophe(movie.getMovieStudio())+", "+putStringIntoApostrophe(movie.getRegie())+", "
                        +putStringIntoApostrophe(movie.getCast())+", "+putStringIntoApostrophe(movie.getTrailerLink())+", true)");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void setMovieInactive(int movieId){
        try {
            Statement stmt = con.createStatement();
            stmt.execute("update movie set active=false where idMovie = "+movieId);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void updateMovie(Movie movie){
        try {
            Statement stmt = con.createStatement();
            stmt.execute("update movie set Title = "+putStringIntoApostrophe(movie.getTitle())+", Duration = "
                    +movie.getDuration()+", AgeRestriction= "+movie.getAgeRestriction()+", imageName= "
                    +putStringIntoApostrophe(movie.getImageName())+", Description = "+putStringIntoApostrophe(movie.getDescription())
                    +", Genre= "+putStringIntoApostrophe(movie.getGenre())+", StartDate = "
                    +putStringIntoApostrophe(JavaUtilDateToString(movie.getStartDate()))+", movieStudio= "
                    +putStringIntoApostrophe(movie.getMovieStudio())+", regie= "+putStringIntoApostrophe(movie.getRegie())
                    +", cast= "+putStringIntoApostrophe(movie.getCast())+", trailerLink = "+putStringIntoApostrophe(movie.getTrailerLink())
                    + "where idMovie = "+movie.getId());
        }catch (Exception e){
            System.out.println(e);
        }
    }


}
