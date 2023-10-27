package com.non.service;

import com.non.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CardService {
    Card createCard(Card card);
    List<Card> getAllCards();
    Card getCardById(Integer id);
    Card updateCard(Integer id, Card card);
    void deleteCard(Integer Id);
}
