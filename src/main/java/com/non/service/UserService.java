package com.non.service;

import com.non.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addNewUser(User user);

}
