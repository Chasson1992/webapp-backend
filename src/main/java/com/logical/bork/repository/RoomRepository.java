package com.logical.bork.repository;

import com.logical.bork.repository.entity.Room;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomRepository extends MongoRepository <Room,String> {

        Room findByName(String name);

        List<Room> findByIsPrivate(boolean isPrivate);
}