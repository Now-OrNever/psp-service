package com.non;
import com.non.exception.ResourceNotFoundException;
import com.non.model.*;
import com.non.repository.QuestionRepository;
import com.non.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PSPMain {

    private static UserRepository userRepository;
    private static QuestionRepository questionRepository;


    public static void main(String[] args) {
        SpringApplication.run(PSPMain.class, args);
        System.out.println("Hare Krishna ");

//        long userId = 1L;
//        User user = userRepository.findById(userId).
//                orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
//        System.out.println(user);
//
//        List<Question> questions = new ArrayList<>();
//        List<Integer> ids = new ArrayList<>();
//        ids.add(1); ids.add(2); ids.add(4);
//        questions = questionRepository.findAllById(ids);
//        System.out.println(questions);
//        user.setQuestions(questions);
//        userRepository.save(user);


    }

}
