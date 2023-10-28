package com.non.service;

import com.non.model.Question;
import com.non.model.QuestionStatus;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuesStatusService {
    QuestionStatus createQuesStatus(QuestionStatus questionStatus);
    List<QuestionStatus> getAllQuesStatus();
    QuestionStatus getQuesStatusById(Integer id);
    QuestionStatus updateQuesStatus(Integer id, QuestionStatus questionStatus);
    String deleteQuesStatus(Integer id);
}
