package com.non.controller;

import com.non.dto.UserDto;
import com.non.model.User;
import com.non.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    UserDto setUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @GetMapping("/")
    List<UserDto> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    UserDto getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    UserDto updateUser(@PathVariable long id, @RequestBody UserDto userDto){
        return userService.updateUser(id, null, userDto, null);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }

}
