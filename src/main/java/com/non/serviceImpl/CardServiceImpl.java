package com.non.serviceImpl;

import com.non.exception.ResourceNotFoundException;
import com.non.model.Card;
import com.non.repository.CardRepository;
import com.non.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;
    @Override
    public Card createCard(Card card) {
        Card c = new Card();
        c.setName(card.getName());
        c.setTimeComp(card.getTimeComp());
        c.setMemComp(card.getMemComp());
        c.setComment(card.getComment());
        c.setDifficulty(card.getDifficulty());
        c.setBookmark(card.getBookmark());
        return cardRepository.save(c);
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCardById(Integer id) {
        return cardRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Card", "Id", id));
    }

    @Override
    public Card updateCard(Integer id, Card card) {
        Card card1 = cardRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Card", "Id", id));
        card1.setComment(card.getComment());
        return cardRepository.save(card1);
    }

    @Override
    public void deleteCard(Integer id) {
        cardRepository.deleteById(id);
    }
}
