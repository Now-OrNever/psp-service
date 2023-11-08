package com.non.algorithm;

import com.non.dto.QuesDto;
import com.non.dto.UserDto;
import com.non.exception.ResourceNotFoundException;
import com.non.model.Card;
import com.non.model.Question;
import com.non.model.User;
import com.non.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.non.Classes.*;

import java.util.ArrayList;
import java.util.List;

import com.non.repository.UserRepository;
@Configuration
public class ExtractCards {

    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;
    @Autowired
    private QuesService quesService;
    @Autowired
    private UserRepository userRepository;

    // Extracts all cards and all question of a users. Cards should be associated with question
    public List<QuesUserCards> getAllCardsAllQues(long userId){
        UserDto userDto = userService.getUser(userId);
        List<QuesDto> questions = userDto.getQuestions();
        List<Card> allCards = userDto.getCards();

        List<QuesUserCards> ans = new ArrayList<>();

        for(int i = 0; i<questions.size(); i++){
            ans.add(new QuesUserCards());
            ans.get(i).setUserId(userId);
            ans.get(i).setUserName(userDto.getUserName());
            ans.get(i).setQuesId(questions.get(i).getId());
            ans.get(i).setQuesName(questions.get(i).getTitle());
            for(Card card:allCards){
                if(card.getQuestion().getId().equals(questions.get(i).getId())){
                    ans.get(i).getCards().add(card);
                }
            }
        }
        return ans;
    }

    // Extract all cards of particular user and question

    public QuesUserCards getAllCardsAQues(long userId, Integer quesId){
        QuesUserCards ans = new QuesUserCards();
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
        QuesDto quesDto = quesService.getQuesById(quesId);
        List<Card> allCards = user.getCards();
        ans.setUserId(userId);
        ans.setQuesId(quesId);
        ans.setQuesName(quesDto.getTitle());
        ans.setUserName(user.getUserName());

        for(Card card:allCards){
            if(card.getQuestion().getId().equals(quesDto.getId())){
                ans.getCards().add(card);
            }
        }
        return ans;
    }

}
