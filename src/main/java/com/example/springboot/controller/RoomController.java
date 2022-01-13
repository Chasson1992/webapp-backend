package com.example.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springboot.service.RoomService;
import com.example.springboot.repository.entity.Room;

@RestController
public class RoomController {

    protected RoomController() {

    }

    @Autowired
    public RoomController(RoomService roomService) {
        this._roomService = roomService;
    }

    @GetMapping("/rooms/{roomId}")
    public Room handleGetRoomById(@PathVariable("roomId") Long roomId) {
        return _roomService.getRoomById(roomId);
    }

    @PostMapping("/rooms/create")
    public void handleCreateRoom(@RequestBody Room newRoom) {
        _roomService.createRoom(newRoom);
    }

    @GetMapping("/rooms/search")
    public List<Room> handleGetAllDiscoverableRooms() {
        return _roomService.getAllDiscoverableRooms();
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    private RoomService _roomService;
}