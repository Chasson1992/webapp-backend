package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.springboot.repository.RoomRepository;
import com.example.springboot.repository.entity.Room;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.repository.entity.User;

@Service
@Transactional
public class RoomService {

    protected RoomService() {

    }

    @Autowired
    public RoomService(
        RoomRepository roomRepository,
        UserRepository userRepository) {

        this._roomRepository = roomRepository;
        this._userRepository = userRepository;
    }

    public void createRoom(Room newRoom) {
        _roomRepository.insert(newRoom);
    }

    public List<Room> getAllDiscoverableRooms() {
        return _roomRepository.findByIsPrivate(false);
    }

    public Room getRoomById(String roomId) {
        if(_roomRepository.findById(roomId).isPresent()) {
            return _roomRepository.findById(roomId).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No room found for id => " + roomId);
        }
    }

    public void addUserToRoom(String roomId, String userId) {
        if(_userRepository.findById(userId).isPresent()) {
            Room room = getRoomById(roomId);
            User user = _userRepository.findById(userId).get();

            // Add user to the room
            room.addUser(user);
            _roomRepository.save(room);

            // Add reference to the room for the user
            user.addRoom(room);
            _userRepository.save(user);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No user found for id => " + userId);
        }
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    private RoomRepository _roomRepository;
    private UserRepository _userRepository;;

}