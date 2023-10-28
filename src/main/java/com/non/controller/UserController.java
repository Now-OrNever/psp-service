package com.non.controller;

import com.non.Classes.UserClass;
import com.non.model.User;
import com.non.repository.UserRepository;
import com.non.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    User setUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/")
    List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }

}
