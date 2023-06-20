package com.non.service;

import java.util.List;

import com.non.model.User;

public interface UserRegisterService {

	List<User> getUser();
	
	User addUser(User user);
}