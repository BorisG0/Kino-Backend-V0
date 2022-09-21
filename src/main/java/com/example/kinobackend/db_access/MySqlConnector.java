package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Movie;
import com.example.kinobackend.responses.Customer;

import java.sql.*;

public class MySqlConnector {
    Connection con;
    public MySqlConnector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinedb", "root", "DBADMIN");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public Movie[] getMovieData(){
        Movie[] data = new Movie[5];

        try {
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

    public Customer[] getCustomerData(){
        Customer[] data = new Customer[5];

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customers");

            for(int i = 0; i < data.length; i++){
                rs.next();
                data[i] = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }
}
