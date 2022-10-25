package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Customer;
import com.example.kinobackend.responses.Employee;
import com.example.kinobackend.responses.User;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserSQL extends MySqlConnector {

    public User getUserFromLoginData(String mailAdress, String password) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select MailAdress, LastName, FirstName, Password from employee where MailAddress = " + putStringIntoApostrophe(mailAdress) + " and Password = " + putStringIntoApostrophe(password));
            if (rs.next()) {
                return new User(User.UserType.Employee,rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
            }else{
                rs = stmt.executeQuery("select MailAdress, LastName, FirstName, Password from customer where MailAddress = " + putStringIntoApostrophe(mailAdress) + " and Password = " + putStringIntoApostrophe(password));
                if (rs.next()){
                    return new User(User.UserType.Customer,rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
                }
            }
            return new User(mailAdress,password);
        } catch (Exception e) {
            System.out.println(e);
            return new User(mailAdress,password);
        }
    }
}
