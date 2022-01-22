package com.logical.bork.repository.entity;

import java.util.Date;

public class Message {

    public Message() {
        super();
    }

    public Message(String text, Date sentTime) {
        this.text = text;
        this.sentTimestamp = sentTime;
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
    private Date sentTimestamp;
    private String text;   
}