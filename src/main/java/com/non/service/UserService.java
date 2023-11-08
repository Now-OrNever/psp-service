package com.non.service;

import com.non.Classes.UserClass;
import com.non.dto.CardDto;
import com.non.dto.UserDto;
import com.non.model.Card;
import com.non.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public UserDto createUser(UserDto userDto);
    public List<UserDto> getUsers();
    public UserDto getUser(Long id);
    public UserDto updateUser(Long id, Integer quesId, UserDto userDto, CardDto cardDto);
    public String deleteUser(Long id);
}
