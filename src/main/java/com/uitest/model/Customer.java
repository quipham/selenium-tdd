package com.uitest.model;

public class Customer {
    private String customerId;
    private String name;
    private String gender;
    private String dob;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String mobileNumber;
    private String email;
    private String pass;

    public String getCustomerId() {
        return customerId;
    }

    public Customer setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Customer setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public Customer setDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Customer setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Customer setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Customer setState(String state) {
        this.state = state;
        return this;
    }

    public String getPin() {
        return pin;
    }

    public Customer setPin(String pin) {
        this.pin = pin;
        return this;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Customer setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public Customer setPass(String pass) {
        this.pass = pass;
        return this;
    }
}
