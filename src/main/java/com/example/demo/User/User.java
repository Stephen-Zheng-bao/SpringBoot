package com.example.demo.User;

import javax.swing.*;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @SequenceGenerator(name = "user_seq",sequenceName = "user_seq",allocationSize = 1)
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "user_seq")

    private Integer UserID;
    private String name;
    private String email;
    private String password;
    private String roles;

    public User(Integer userID, String name, String email, String password, String roles) {
        UserID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public User(){

    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
