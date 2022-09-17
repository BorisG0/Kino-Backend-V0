package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Movie;

import java.sql.*;

public class MySqlConnector {
    public Movie[] getMovieData(){
        Movie[] data = new Movie[5];

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kinotest", "root", "123");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from movies");

            for(int i = 0; i < data.length; i++){
                rs.next();
                data[i] = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }
}
