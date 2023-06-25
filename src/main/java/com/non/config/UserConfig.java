package com.non.config;

import com.non.model.User;
import com.non.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        User sanskar = new User("sanskar_01", "Sanskar", "Agrawal", "sanskaaragrawal2001@gmail.com");
        userRepository.save(sanskar);
        return args -> {
        };
    }
}
