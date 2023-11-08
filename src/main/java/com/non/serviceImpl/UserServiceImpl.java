package com.non.serviceImpl;

import com.non.dto.CardDto;
import com.non.dto.QuesDto;
import com.non.dto.UserDto;
import com.non.exception.ResourceNotFoundException;
import com.non.model.Card;
import com.non.model.Question;
import com.non.model.User;
import com.non.repository.UserRepository;
import com.non.service.QuesService;
import com.non.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuesService quesService;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return  this.modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user:users) userDtos.add(this.modelMapper.map(user, UserDto.class));
        return userDtos;
    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, Integer quesId, UserDto userDto, CardDto cardDto) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));

        if(userDto != null){
            user.setName(userDto.getName());
            user.setUserName(userDto.getUserName());
        }
        if(cardDto != null) {
            user.getCards().add(this.modelMapper.map(cardDto, Card.class));
            // Saving User in card is removed
        }
        if(quesId != null) {
            QuesDto quesDto = quesService.getQuesById(quesId);
            user.getQuestions().add(this.modelMapper.map(quesDto, Question.class));
            this.modelMapper.map(quesDto, Question.class).getUsers().add(
                    this.modelMapper.map(userDto, User.class)
            );
            quesService.updateQues(quesId, quesDto, null);
        }
        return this.modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User is deleted with Id: " + id;
    }
}
