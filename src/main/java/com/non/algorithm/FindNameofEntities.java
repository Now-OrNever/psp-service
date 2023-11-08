package com.non.algorithm;

import com.non.dto.QuesDto;
import com.non.dto.UserDto;
import com.non.model.Question;
import com.non.model.User;
import com.non.repository.UserRepository;
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
        List<QuesDto> quesDtos = this.quesService.getAllQues();
         Map<Integer, String> names = new HashMap<>();
        for (QuesDto quesDto : quesDtos) {
            names.put(quesDto.getId(), quesDto.getTitle());
        }
        return names;
    }

    @Bean
    public Map<Long, String> Users(){
        List<UserDto> userDtos = this.userService.getUsers();
        Map<Long, String> names = new HashMap<>();
        for (UserDto userDto : userDtos) {
            names.put(userDto.getUserId(), userDto.getUserName());
        }
        return names;
    }
}
