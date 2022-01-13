package com.example.springboot.repository;

import com.example.springboot.repository.entity.Room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository <Room,Long> {

        Room findByName(String name);

        List<Room> findByIsPrivate(boolean isPrivate);
}