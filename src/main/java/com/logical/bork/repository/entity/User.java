package com.logical.bork.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Collections;

import com.logical.bork.repository.entity.Room;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Document(collection = "users")
public class User {

    public User() {
        super();
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = new Date();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCreatedDate(Date created) {
        this.created = created;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Date created;

    private Date lastLoggedIn;

    private boolean isOnline;

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true) 
    @DBRef (lazy = true)
    private List<Room> rooms = new ArrayList<Room>();
}