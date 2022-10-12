package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Employee;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeSQL extends MySqlConnector{

    public Employee[] getEmployeeData(){

        ArrayList<Employee> data = new ArrayList<Employee>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee");

            while (rs.next()) {
                data.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return data.toArray(new Employee[0]);

    }
    public Employee getEmployeeByMailAdress(String mailAdress){
        Employee employee = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee where MailAddress = "+putStringIntoApostrophe(mailAdress));
            rs.next();
            employee = new Employee(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5));
        }catch (Exception e){
            System.out.println(e);
        }
        return employee;
    }
    public void addEmployee(Employee employee){
        try {
            Statement stmt = con.createStatement();
            stmt.execute("insert into employee (MailAddress, LastName, FirstName, Role, Password ) values (" + putStringIntoApostrophe(employee.getMailAdress())+", "+putStringIntoApostrophe(employee.getLastName())+", "+putStringIntoApostrophe(employee.getFirstName())+", "+putStringIntoApostrophe(employee.getRole())+", "+putStringIntoApostrophe(employee.getPassword()));
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
