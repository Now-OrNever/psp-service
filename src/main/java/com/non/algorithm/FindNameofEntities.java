package com.non.algorithm;

import com.non.model.Question;
import com.non.model.User;
import com.non.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class FindNameofEntities {

    @Autowired
    private QuesService quesService;

    @Autowired
    private UserService userService;

    @Bean
     public Map<Integer, String> Questions(){
        List<Question> questions = quesService.getAllQues();
         Map<Integer, String> names = new HashMap<>();
        for (Question question : questions) {
            names.put(question.getId(), question.getTitle());
        }
        return names;
    }

    @Bean
    public Map<Long, String> Users(){
        List<User> users = userService.getUsers();
        Map<Long, String> names = new HashMap<>();
        for (User user : users) {
            names.put(user.getUserId(), user.getUserName());
        }
        return names;
    }
}
