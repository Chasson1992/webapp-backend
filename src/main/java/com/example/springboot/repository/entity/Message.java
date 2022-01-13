package com.example.springboot.repository.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Message {

    public Message() {
        super();
    }

    public Message(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSentTimestamp(Date time) {
        this.sentTimestamp = time;
    }

    public Date getSentTimestamp() {
        return sentTimestamp;
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    private Date sentTimestamp;
    private String text;   
}