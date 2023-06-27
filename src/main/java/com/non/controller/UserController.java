package com.non.controller;

import com.non.exception.ApiException;
import com.non.model.User;
import com.non.service.UserService;
import com.non.util.PspServiceConstants;
import com.scaffolding.util.PlatformConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = PspServiceConstants.ACCESS_CONTROL_ALLOW_ORIGIN_VALUE, allowedHeaders = PspServiceConstants.ACCESS_CONTROL_ALLOW_ORIGIN_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        try{
            return userService.getAllUsers();
        }catch (ApiException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
