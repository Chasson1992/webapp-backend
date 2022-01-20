package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.springboot.repository.UserRepository;
import com.example.springboot.repository.entity.User;

@Service
@Transactional
public class UserService {

    protected UserService() {

    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this._userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return _userRepository.findAll();
    }

    public void insertUser(User newUser) {
        _userRepository.save(newUser);
    }

    public User getUserById(String id) {
        if(_userRepository.findById(id).isPresent()) {
            return _userRepository.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found for id => " + id);
        }
    }

    public List<User> getUsersFilteredByOnline(boolean isonline) {
        return _userRepository.findByIsOnline(isonline);
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    private UserRepository _userRepository;

}