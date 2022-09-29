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
            ResultSet rs = stmt.executeQuery("select * from customers");

            while(rs.next()){
                data.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return data.toArray(new Customer[0]);
    }
}
