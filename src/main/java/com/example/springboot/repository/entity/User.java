package com.example.springboot.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        for(Room room : rooms) {
            addRoom(room);
        }
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void removeRoom(Room room) {
        this.rooms.remove(room);
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

    @ManyToMany(
        fetch = FetchType.EAGER, 
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
        name = "user_rooms",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name ="room_id", referencedColumnName = "id")
    )
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    private List<Room> rooms = new ArrayList<Room>();
}