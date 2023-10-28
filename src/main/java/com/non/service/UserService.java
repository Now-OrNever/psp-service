package com.non.service;

import com.non.Classes.UserClass;
import com.non.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public User createUser(User user);
    public List<User> getUsers();
    public User getUser(Long id);
    public User updateUser(Long id, User user);
    public String deleteUser(Long id);
}
