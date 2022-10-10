package com.example.kinobackend.db_access;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date) ;
        return dateString;
    }






}
