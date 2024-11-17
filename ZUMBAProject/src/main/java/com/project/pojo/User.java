package com.project.pojo;



import java.util.Date;

public class User {
    private String name;
    private String password;
    private String email;
    private Date dob;
    private String gender;

    // Constructor
    public User(String name, String password, String email, Date dob, String gender) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}