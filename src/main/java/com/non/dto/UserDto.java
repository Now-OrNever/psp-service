package com.non.dto;

import com.non.model.Card;
import com.non.model.QuestionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {
    private long userId;
    private String userName;
    private String name;
    private List<Card> cards = new ArrayList<>();
    private List<QuestionStatus> questionStatuses = new ArrayList<>();
    private List<QuesDto> questions = new ArrayList<>();
}
