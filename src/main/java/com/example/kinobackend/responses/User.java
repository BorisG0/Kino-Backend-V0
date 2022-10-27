package com.example.kinobackend.responses;

public class User {
    public enum UserType {Employee,Customer,NoUserFound,UserExists};
    private UserType userType;
    private String mailAdress;
    private String password;
    private String lastName;
    private String firstName;

    public User(){}
    public User(String mailAdress, String password) {
        this.userType = UserType.NoUserFound;
        this.mailAdress = mailAdress;
        this.password = password;
    }
    public User(String mailAdress) {
        this.userType = UserType.UserExists;
        this.mailAdress = mailAdress;
    }

    public User(UserType userType, String mailAdress, String password, String lastName, String firstName) {
        this.userType = userType;
        this.mailAdress = mailAdress;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
