package com.non;
import com.non.exception.ResourceNotFoundException;
import com.non.model.*;
import com.non.repository.QuestionRepository;
import com.non.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@ComponentScan("com.non")
@SpringBootApplication
public class PSPMain {

    private static UserRepository userRepository;
    private static QuestionRepository questionRepository;


    public static void main(String[] args) {
        SpringApplication.run(PSPMain.class, args);
        System.out.println("App Initialised");
    }

}
