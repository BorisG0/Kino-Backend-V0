package com.example.kinobackend.responses;

public class User {
    public enum UserType {Employee,Customer,NoUserFound};
    private UserType userType;
    private String mailAdress;
    private String lastname;
    private String firstname;
    private int age;
    private int postalCode;
    private int houseNumber;
    private String location;
    private String street;
    private String countryCode;
    private String mobileNumber;
    private String password;
    private String role;

    public User( String mailAdress, String lastname, String firstname, int age, int postalCode, int houseNumber, String location, String street, String countryCode, String mobileNumber, String password) {
        this.userType = UserType.Customer;
        this.mailAdress = mailAdress;
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.location = location;
        this.street = street;
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public User(String mailAdress, String lastname, String firstname, String role, String password) {
        this.userType = UserType.Employee;
        this.mailAdress = mailAdress;
        this.lastname = lastname;
        this.firstname = firstname;
        this.role = role;
        this.password = password;
    }

    public User(){
        this.userType = UserType.NoUserFound;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
