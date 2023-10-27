package com.non.controller;

import com.non.model.Card;
import com.non.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
@RequestMapping("/card/")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/post")
    public Card createCard(@RequestBody Card card){
        return cardService.createCard(card);
    }

    @GetMapping("/get-all")
    public List<Card> GetAll(){
        return cardService.getAllCards();
    }

    @GetMapping("{id}")
    public Card GetById(@PathVariable Integer id){
        return cardService.getCardById(id);
    }

    @PutMapping("/put/{id}")
    public Card PutCard(@PathVariable Integer id, @RequestBody Card card){
        return cardService.updateCard(id, card);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Integer id){
        cardService.deleteCard(id);
    }

}
