package com.non.controller;

import com.non.exception.ResourceNotFoundException;
import com.non.model.Question;
import com.non.model.User;
import com.non.repository.QuestionRepository;
import com.non.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analysis")
public class Analysis {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("/users")
    Map<Long, String> sendUsers() {
        List<User> users = userRepository.findAll();
        Map<Long, String> map = new HashMap<>();
        for(int i=0; i<users.size(); i++){
            map.put(users.get(i).getUserId(), users.get(i).getUserName());
        }
        return map;
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

    @RequestMapping("/questions")
    List<Question> sendQues() {
        List<Question> questions = questionRepository.findAll();
        return questions;
    }

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
