package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.springboot.repository.RoomRepository;
import com.example.springboot.repository.entity.Room;

@Service
@Transactional
public class RoomService {

    protected RoomService() {

    }

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this._roomRepository = roomRepository;
    }

    public void createRoom(Room newRoom) {
        _roomRepository.save(newRoom);
    }

    public List<Room> getAllDiscoverableRooms() {
        return _roomRepository.findByIsPrivate(false);
    }

    public Room getRoomById(Long roomId) {
        if(_roomRepository.findById(roomId).isPresent()) {
            return _roomRepository.findById(roomId).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No room found for id => " + roomId);
        }
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    private RoomRepository _roomRepository;

}