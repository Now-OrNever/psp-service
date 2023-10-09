package com.non.controller;

import com.non.Classes.UserClass;
import com.non.exception.ResourceNotFoundException;
import com.non.model.Question;
import com.non.model.User;
import com.non.repository.QuestionRepository;
import com.non.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
@RequestMapping("/analysis")
public class Analysis {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("/users")
    List<UserClass> sendUsers() {
        List<User> users = userRepository.findAll();
        List<UserClass> userClass = new ArrayList<>();
        for(Integer i=0; i<users.size(); i++){
            UserClass user = new UserClass(users.get(i).getUserId(), users.get(i).getName(), users.get(i).getQuestions().size());
            userClass.add(user);
        }
        return userClass;
    }

    @RequestMapping("/users/{userId}")
    User sendUser(@PathVariable long userId){
        User user = userRepository.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
        return user;
    }

    @RequestMapping("/users/{userId}/questions")
    List<Question> sendQuestions(@PathVariable long userId){
        User user = userRepository.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
        List<Question> questions = user.getQuestions();
        return questions;
    }

//    @RequestMapping("/questions")
//    List<Question> sendQues() {
//        List<Question> questions = questionRepository.findAll();
//        return questions;
//    }

    // Filling user_question table
//    @RequestMapping("/userID")
//    User sendUser(){
//        long userId = 3L;
//        User user = userRepository.findById(userId).
//                orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
//        System.out.println(user);
//        List<Question> questions = new ArrayList<>();
//        List<Integer> ids = new ArrayList<>();
//        ids.add(3); ids.add(5); ids.add(6);
//        questions = questionRepository.findAllById(ids);
//        System.out.println(questions);
//        user.setQuestions(questions);
//        userRepository.save(user);
//        return user;
//    }

}
