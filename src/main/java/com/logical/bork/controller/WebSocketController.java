package com.logical.bork.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.beans.factory.annotation.Autowired;

import com.logical.bork.repository.entity.User;
import com.logical.bork.repository.entity.Message;
import com.logical.bork.service.RoomService;

@Controller
public class WebSocketController {

    protected WebSocketController() {

    }

    @Autowired
    public WebSocketController(RoomService roomService) {
        this._roomService = roomService;
    }

    @MessageMapping("/messages/{roomId}")
    @SendTo("/topic/messages/{roomId}")
    public Message index(@DestinationVariable("roomId") String roomId, Message message) {
        System.out.println("Got message for :  " + roomId + " with contents " + message.getText());
        _roomService.createNewMessage(roomId, message);
        return message;
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    private RoomService _roomService;
}