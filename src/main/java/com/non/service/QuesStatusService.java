package com.non.service;

import com.non.model.Question;
import com.non.model.QuestionStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface QuesStatusService {
    QuestionStatus createQuesStatus();
    List<QuestionStatus> getAllQuesStatus();
    QuestionStatus getQuesStatusById();
    QuestionStatus updateQuesStatus();
    void deleteQuesStatus();
}
