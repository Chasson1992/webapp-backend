package com.example.springboot.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

@Entity
public class Room {

    public Room() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean bool) {
        this.isPrivate = bool;
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(
            messages.stream().collect(Collectors.toList()));
    }

    public void insertMessage(Message msg) {
        try {
            messages.addLast(msg);
        } catch (IllegalStateException exception) {
            // Change this to logging later
            System.out.println("Error adding message : " + exception.toString());
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean isPrivate;

    @ManyToMany(
        mappedBy = "rooms",
        fetch = FetchType.EAGER, 
        cascade = {
            CascadeType.ALL})
    private List<User> users = new ArrayList<User>();

    private ConcurrentLinkedDeque<Message> messages =
                new ConcurrentLinkedDeque<Message>();

}