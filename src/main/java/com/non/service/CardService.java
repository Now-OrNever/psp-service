package com.non.service;

import com.non.dto.CardDto;
import com.non.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CardService {
    CardDto createCard(CardDto cardDto);
    List<CardDto> getAllCards();
    CardDto getCardById(Integer id);
    CardDto updateCard(Integer id, CardDto cardDto);
    void deleteCard(Integer id);
}
