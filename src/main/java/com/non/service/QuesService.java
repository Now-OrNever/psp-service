package com.non.service;

import com.non.model.Question;
import com.non.model.QuestionStatus;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuesService {
    Question createQues(Question question);
    List<Question> getAllQues();
    Question getQuesById(Integer id);
    Question updateQues(Integer id, Question question);
    String deleteQues(Integer id);
    String updateQuesStatus(Integer quesId, Integer statusId);


}
