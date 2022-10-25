package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Customer;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public final class CustomerSQL extends MySqlConnector{

    public Customer[] getCustomerData(){
        ArrayList<Customer> data = new ArrayList<Customer>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");

            while(rs.next()){
                data.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getString(11)));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return data.toArray(new Customer[0]);
    }
    public Customer getCustomerByMailAdress(String mailAdress){
        Customer customer = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer where MailAddress = "+putStringIntoApostrophe(mailAdress));
            rs.next();
            customer = new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4), rs.getInt(5),rs.getInt(6),rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10),rs.getString(11));
        }catch (Exception e){
            System.out.println(e);
        }
        return customer;
    }

    public void addCustomer(Customer customer){
        try {
            Statement stmt = con.createStatement();
            stmt.execute("insert into customer (MailAddress, LastName, FirstName, BirthDate, PLZ, HouseNumber, Location, Street, Country, MobileNumber, Password) VALUES (" + putStringIntoApostrophe(customer.getMailAdress())+", "+putStringIntoApostrophe(customer.getLastName())+", "+putStringIntoApostrophe(customer.getFirstName())+", "+putStringIntoApostrophe(JavaUtilDateToString(customer.getBirthDate()))+", "+customer.getPostalCode()+", "+customer.getHouseNumber()+", "+putStringIntoApostrophe(customer.getLocation())+", "+putStringIntoApostrophe(customer.getStreet())+", "+putStringIntoApostrophe(customer.getCountryCode())+", "+putStringIntoApostrophe(customer.getMobileNumber())+", "+putStringIntoApostrophe(customer.getPassword()));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
