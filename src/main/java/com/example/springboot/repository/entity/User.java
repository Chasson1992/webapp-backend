package com.example.springboot.repository.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

    public User() {
        super();
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreationDate() {
        return created;
    }

    public Date getLastLoggedInDate() {
        return lastLoggedIn;
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastLoggedInDate(Date lastLogIn) {
        this.lastLoggedIn = lastLogIn;
    }

    public void setIsOnline(boolean online) {
        this.isOnline = online;
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @CreationTimestamp
    private Date created;
    private Date lastLoggedIn;
    private boolean isOnline;
}