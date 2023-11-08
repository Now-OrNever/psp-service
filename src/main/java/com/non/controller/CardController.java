package com.non.controller;

import com.non.dto.CardDto;
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
    public CardDto createCard(@RequestBody CardDto cardDto){
        return cardService.createCard(cardDto);
    }

    @GetMapping("/get-all")
    public List<CardDto> GetAll(){
        return cardService.getAllCards();
    }

    @GetMapping("{id}")
    public CardDto GetById(@PathVariable Integer id){
        return cardService.getCardById(id);
    }

    @PutMapping("/put/{id}")
    public CardDto PutCard(@PathVariable Integer id, @RequestBody CardDto cardDto){
        return cardService.updateCard(id, cardDto);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Integer id){
        cardService.deleteCard(id);
    }

}
