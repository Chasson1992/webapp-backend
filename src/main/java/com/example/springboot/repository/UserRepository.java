package com.example.springboot.repository;

import com.example.springboot.repository.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User,Long> {

    List<User> findByLastName(String lastName);

    List<User> findByIsOnline(boolean online);
}