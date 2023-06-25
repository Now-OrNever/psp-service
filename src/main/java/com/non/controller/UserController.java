package com.non.controller;

import com.non.model.User;
import com.non.repository.UserRepository;
import com.non.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){ this.userService = userService; }
    @GetMapping("fetch-all-users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
