package com.logical.bork.repository;

import com.logical.bork.repository.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository <User,String> {

    List<User> findByLastName(String lastName);

    List<User> findByIsOnline(boolean online);
}