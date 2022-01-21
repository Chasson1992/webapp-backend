package com.logical.bork.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.logical.bork.service.RoomService;
import com.logical.bork.repository.entity.Room;
import com.logical.bork.repository.entity.User;
import com.logical.bork.repository.entity.Message;

@RestController
public class RoomController {

    protected RoomController() {

    }

    @Autowired
    public RoomController(RoomService roomService) {
        this._roomService = roomService;
    }

    @GetMapping("/api/rooms/search/roomId")
    public Room handleGetRoomById(@RequestParam("roomId") String roomId) {
        return _roomService.getRoomById(roomId);
    }

    @PostMapping("/api/rooms/create")
    public void handleCreateRoom(@RequestBody Room newRoom) {
        _roomService.createRoom(newRoom);
    }

    @PostMapping("/api/rooms/addUser")
    public void handleCreateRoom(@RequestParam("roomId") String roomId, @RequestParam("userId") String userId) {
        _roomService.addUserToRoom(roomId, userId);
    }

    @PostMapping("/api/rooms/addMessage")
    public void handleCreateNewMessage(@RequestParam("roomId") String roomId, @RequestBody Message message) {
        _roomService.createNewMessage(roomId, message);
    }

    @GetMapping("/api/rooms")
    public List<Room> handleGetAllDiscoverableRooms() {
        return _roomService.getAllDiscoverableRooms();
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    private RoomService _roomService;
}