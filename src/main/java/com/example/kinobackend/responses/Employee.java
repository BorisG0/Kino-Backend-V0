package com.example.kinobackend.responses;

public class Employee extends User{
    private String role;


    public Employee(){}
    public Employee(String mailAdress, String lastName, String firstName, String role, String password) {
        super(UserType.Employee,mailAdress,password,lastName,firstName);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
