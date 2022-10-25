package com.example.kinobackend.responses;

import java.util.Date;

public class Customer extends User{
    private Date birthDate;
    private int postalCode;
    private int houseNumber;
    private String location;
    private String street;
    private String countryCode;
    private String mobileNumber;

    public Customer(){}
    public Customer(String mailAdress, String lastName, String firstName, Date birthDate, int postalCode, int houseNumber, String location, String street, String countryCode, String mobileNumber, String password) {
        super(UserType.Customer,mailAdress,password,lastName,firstName);
        this.birthDate = birthDate;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.location = location;
        this.street = street;
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
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

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
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
}
