package com.non.service;

import com.non.dto.CardDto;
import com.non.dto.QuesDto;
import com.non.model.Card;
import com.non.model.Question;
import com.non.model.QuestionStatus;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuesService {
    QuesDto createQues(QuesDto quesDto);
    List<QuesDto> getAllQues();
    QuesDto getQuesById(Integer id);
    QuesDto updateQues(Integer id, QuesDto quesDto, CardDto cardDto);
    String deleteQues(Integer id);
    String updateQuesStatus(Integer quesId, Integer statusId);


}
