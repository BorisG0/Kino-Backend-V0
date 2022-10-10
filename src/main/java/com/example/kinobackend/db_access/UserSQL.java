package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Customer;
import com.example.kinobackend.responses.Employee;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserSQL extends MySqlConnector {

    public String getUserFromLoginData(String mailAdress, String password) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee where MailAddress = " + putStringIntoApostrophe(mailAdress) + " and Password = " + putStringIntoApostrophe(password));
            if (rs.next() == true) {
                //return User = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                return "Employee";
            }else{
                rs = stmt.executeQuery("select * from customer where MailAddress = " + putStringIntoApostrophe(mailAdress) + " and Password = " + putStringIntoApostrophe(password));
                if (rs.next() == true){
                    //return User = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getString(11));
                    return "Customer";
                }
            }
            return "NoUserFound";
        } catch (Exception e) {
            System.out.println(e);
            return "Error Accessing Data";
        }
    }
}
