package com.example.springboot.controller;

import java.util.List;

import java.lang.Long;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springboot.service.UserService;
import com.example.springboot.repository.entity.User;

@RestController
public class UserController {

    protected UserController() {

    }

    @Autowired
    public UserController(UserService userService) {
        this._userService = userService;
    }

    @GetMapping("/api/users")
    public List<User> handleGetUsers() {
        return _userService.getAllUsers();
    }

    @PostMapping("/api/users/add")
    public void handleAddUser(@RequestBody User newUser) {
        _userService.insertUser(newUser);
    }

    @GetMapping("/api/users/{id}")
    public User handleGetUserById(@PathVariable("id") Long userId) {
        return _userService.getUserById(userId);
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    private UserService _userService;
}