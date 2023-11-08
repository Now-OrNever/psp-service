package com.non.Classes;

import com.non.model.Card;
import com.non.model.Question;
import com.non.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuesUserCards {

    private long userId;
    private Integer quesId;
    private String userName;
    private String quesName;
    private List<Card> cards = new ArrayList<>();

//    public List<Card> getCards(){
//        return this.cards;
//    }
//
//    public void setCards(List<Card> cards){
//        this.cards = cards;
//    }
}
