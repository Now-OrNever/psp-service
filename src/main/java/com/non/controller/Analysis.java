package com.non.controller;

import com.non.model.Question;
import com.non.model.User;
import com.non.repository.QuestionRepository;
import com.non.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analysis")
public class Analysis {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("/users")
    List<User> sendUsers() {
        List<User> users = userRepository.findAll();
        System.out.println(users.get(0).getUserName());
        return users;
    }

    @RequestMapping("/questions")
    List<Question> sendQues() {
        List<Question> questions = questionRepository.findAll();
        System.out.println(questions.get(0).getTitle());
        return questions;
    }

}
