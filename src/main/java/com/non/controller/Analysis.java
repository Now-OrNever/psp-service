package com.non.controller;

import com.non.exception.ResourceNotFoundException;
import com.non.model.Question;
import com.non.model.User;
import com.non.repository.QuestionRepository;
import com.non.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.non.algorithm.FindNameofEntities;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
@RequestMapping("/analysis")
public class Analysis {

    @Autowired
    private FindNameofEntities findNameofEntities;

    // Sent all users' names and questions' names to user
    @GetMapping("/user-names")
    Map<Long, String> getNamesOfUsers(){
        return findNameofEntities.Users();
    }

    @GetMapping("/ques-names")
    Map<Integer, String> getNamesOfQues(){
        return findNameofEntities.Questions();
    }
}
