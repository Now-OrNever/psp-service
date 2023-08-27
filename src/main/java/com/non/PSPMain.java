package com.non;

import com.non.repository.QuestionRepository;
import com.non.repository.UserRepository;
import com.non.model.Question;
import com.non.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class PSPMain {

    public static void main(String[] args) {
        SpringApplication.run(PSPMain.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(UserRepository userRepository, QuestionRepository questionRepository) {
//        return args -> {
//
//            Optional<Question> question1Optional = questionRepository.findById("Q1");
//            Optional<Question> question2Optional = questionRepository.findById("Q2");
//
//            Optional<User> userOptional1 = userRepository.findById(1L);
//            Optional<User> userOptional2 = userRepository.findById(2L);
//
//            if (question1Optional.isPresent() && question2Optional.isPresent() &&
//                    userOptional1.isPresent() && userOptional2.isPresent()) {
//
//                Question question1 = question1Optional.get();
//                Question question2 = question2Optional.get();
//
//                User user1 = userOptional1.get();
//                User user2 = userOptional2.get();
//
//                question1.getUsers().add(user1);
//                question2.getUsers().add(user1);
//                question2.getUsers().add(user2);
//
//                user1.getUserQues().add(question1);
//                user1.getUserQues().add(question2);
//                user2.getUserQues().add(question1);
//
//                userRepository.save(user1);
//                userRepository.save(user2);
//            }
//
//            List<Question> questions = questionRepository.findAll();
//            List<User> users = userRepository.findAll();
//
//            for (Question question : questions) {
//                System.out.println("Users for Question " + question.getQuestionId() + ": " + question.getUsers());
//            }
//
//            for (User user : users) {
//                System.out.println("Questions for User " + user.getUserId() + ": " + user.getUserQues());
//            }
//        };
//    }
}
