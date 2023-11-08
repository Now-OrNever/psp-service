package com.non.controller;

import com.non.Classes.QuesUserCards;
import com.non.algorithm.ExtractCards;
import com.non.dto.CardDto;
import com.non.dto.UserDto;
import com.non.model.Card;
import com.non.service.CardService;
import com.non.service.QuesService;
import com.non.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import com.non.algorithm.FindNameofEntities;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
@RequestMapping("/analysis")
public class Analysis {

    @Autowired
    private FindNameofEntities findNameofEntities;
    @Autowired
    private ExtractCards extractCards;
    @Autowired
    private QuesService quesService;
    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;

    // Sent all users' names and questions' names to user
    @GetMapping("/user-names")
    Map<Long, String> getNamesOfUsers(){
        return findNameofEntities.Users();
    }

    @GetMapping("/ques-names")
    Map<Integer, String> getNamesOfQues(){
        return findNameofEntities.Questions();
    }

    @GetMapping("/{userId}")
    List<QuesUserCards> getAllCardsAllQues(@PathVariable long userId){
        return extractCards.getAllCardsAllQues(userId);
    }

    @GetMapping("/{userId}/{quesId}")
    QuesUserCards getAllCardsAQues(@PathVariable long userId, @PathVariable Integer quesId){
        return extractCards.getAllCardsAQues(userId, quesId);
    }

    @PutMapping("/{userId}/{quesId}")
    String addCard(@PathVariable Long userId, @PathVariable Integer quesId, @RequestBody CardDto cardDto){
        CardDto cardDto2 = cardService.createCard(cardDto);
        userService.updateUser(userId, quesId, null, cardDto2);
        quesService.updateQues(quesId, null, cardDto2);
        cardService.updateCard(cardDto2.getId(), cardDto2);
        return "Card added successfully";
    }

    @PutMapping("/aqtou/{userId}/{quesId}")
    UserDto addQues(@PathVariable Long userId, @PathVariable Integer quesId){
        return userService.updateUser(userId, quesId, null, null);
    }

}
