package com.example.kinobackend.responses;

public class Employee {
    private String mailAdress;
    private String lastname;
    private String firstname;
    private String role;
    private String password;

    public Employee(String mailAdress, String lastname, String firstname, String role, String password) {
        this.mailAdress = mailAdress;
        this.lastname = lastname;
        this.firstname = firstname;
        this.role = role;
        this.password = password;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
