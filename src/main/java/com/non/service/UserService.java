package com.non.service;

import com.non.Classes.UserClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserClass createUser();
    public List<UserClass> getUsers();
    public UserClass getUser();
    public UserClass updateUser();
    public void deleteUser();
}
