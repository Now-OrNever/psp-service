package com.non.serviceImpl;

import com.non.Classes.UserClass;
import com.non.exception.ResourceNotFoundException;
import com.non.model.User;
import com.non.repository.UserRepository;
import com.non.service.UserService;

import java.util.ArrayList;
import java.util.List;


public abstract class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserClass createUesr(UserClass user){
        User model = this.userToModel(user);
        userRepository.save(model);
        return user;
    }

    @Override
    public List<UserClass> getUsers(){
        List<User> users = userRepository.findAll();
        List<UserClass> userClass = new ArrayList<>();
        for (User value : users) {
            UserClass user = this.modelToUser(value);
            userClass.add(user);
        }
        return userClass;
    }

    UserClass getUser(long id){
        User user = this.userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
        return modelToUser(user);
    }
    UserClass updateUser(long id, UserClass userClass){
        User user = this.userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
        user.setUserName(userClass.getUserName());
        user.setName(userClass.getName());
        User updatedUser = userRepository.save(user);
        return modelToUser(updatedUser);
    }

    String deleteUser(long id){
        userRepository.deleteById(id);
        return "User deleted with id: " + id ;
    }

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
