package com.non.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.non.model.User;
import com.non.repository.UserRepository;

@Service
public class UserRegisterServiceImpl implements UserRegisterService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}
	
	@Override
	public User addUser(User user) {
		userRepository.save(user);
		return user;
	}

}
