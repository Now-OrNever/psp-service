package com.non.serviceImpl;

import com.non.dto.CardDto;
import com.non.exception.ResourceNotFoundException;
import com.non.model.Card;
import com.non.repository.CardRepository;
import com.non.service.CardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CardDto createCard(CardDto cardDto) {
        return this.modelMapper.map(cardRepository.save(
                this.modelMapper.map(cardDto, Card.class)
        ), CardDto.class);
    }

    @Override
    public List<CardDto> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        List<CardDto> cardDtos = new ArrayList<>();
        for(Card card:cards){
            cardDtos.add(this.modelMapper.map(card, CardDto.class));
        }
        return cardDtos;
    }

    @Override
    public CardDto getCardById(Integer id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Card", "Id", id));
        return this.modelMapper.map(card, CardDto.class);
    }

    @Override
    public CardDto updateCard(Integer id, CardDto cardDto) {
        Card card1 = cardRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Card", "Id", id));
        card1.setName(cardDto.getName());
        card1.setTimeComp(cardDto.getTimeComp());
        card1.setMemComp(cardDto.getMemComp());
        card1.setComment(cardDto.getComment());
        card1.setDifficulty(cardDto.getDifficulty());
        card1.setBookmark(cardDto.getBookmark());
        card1.setComment(cardDto.getComment());
        return this.modelMapper.map(cardRepository.save(card1), CardDto.class);
    }

    @Override
    public void deleteCard(Integer id) {
        cardRepository.deleteById(id);
    }
}
