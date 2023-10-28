package com.non.serviceImpl;

import com.non.Classes.UserClass;
import com.non.exception.ResourceNotFoundException;
import com.non.model.User;
import com.non.repository.UserRepository;
import com.non.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
    }

    @Override
    public User updateUser(Long id, User user) {
        User user1 = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));

        user1.setName(user.getName());
        user1.setUserName(user.getUserName());
        return userRepository.save(user1);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User is deleted with Id: " + id;
    }


    // Extra Methods

    private User userToModel(UserClass user){
        User model = new User();
        model.setName(user.getName());
        model.setUserName(user.getUserName());
        return model;
    }

    private UserClass modelToUser(User model){
        UserClass user = new UserClass();
        user.setId(model.getUserId());
        user.setUserName(model.getUserName());
        user.setName(model.getName());
        user.setQues(model.getQuestions().size());
        return user;
    }

}
