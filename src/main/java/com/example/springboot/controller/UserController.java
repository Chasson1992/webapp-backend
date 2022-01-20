package com.example.springboot.controller;

import java.util.List;

import java.lang.Long;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/api/users/search/id")
    public User handleGetUserById(@RequestParam("id") String userId) {
        return _userService.getUserById(userId);
    }

    @GetMapping("/api/users/search/online")
    public List<User> handleGetUsersByOnline(@RequestParam("online") Boolean isOnline) {
        return _userService.getUsersFilteredByOnline(isOnline);
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    private UserService _userService;
}