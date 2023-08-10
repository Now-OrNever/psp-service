package com.non.controller;


import com.non.exception.QuestionNotFoundException;
import com.non.exception.QuestionStatusNotFoundException;
import com.non.model.QuestionStatus;
import com.non.repository.QuestionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/non/questionstatus")
public class QuestionStatusController {

    @Autowired
    QuestionStatusRepository questionStatusRepository;

    public QuestionStatusController(QuestionStatusRepository questionStatusRepository) {
        this.questionStatusRepository = questionStatusRepository;
    }

    @GetMapping("/{questionId}/{userId}")
    public QuestionStatus findQuestionStatus(@PathVariable String questionId, @PathVariable String userId){
        QuestionStatus questionStatus = questionStatusRepository.findByQuestionIdAndUserId(questionId, userId);
        if (questionStatus == null){
            questionStatus = new QuestionStatus();
            questionStatus.setQuestionId(questionId);
            questionStatus.setUserId(userId);
            questionStatus.setStatus("Pending");
            questionStatusRepository.save(questionStatus);
        }

        return questionStatus;
    }

    @PutMapping("statusUpdate/{questionId}/{userId}")
    public QuestionStatus updateQuestionStatus(@RequestBody QuestionStatus newQuestionStatus, @PathVariable String questionId, @PathVariable String userId){
        QuestionStatus questionStatus = questionStatusRepository.findByQuestionIdAndUserId(questionId, userId);

        if(questionStatus==null){
            throw new QuestionStatusNotFoundException(questionId, userId);
        }

        questionStatus.setStatus(newQuestionStatus.getStatus());
        questionStatusRepository.save(questionStatus);
        return questionStatus;
    }

    @PutMapping("noteUpdate/{questionId}/{userId}")
    public QuestionStatus updateNote(@RequestBody QuestionStatus newQuestionStatus, @PathVariable String questionId, @PathVariable String userId){
        QuestionStatus questionStatus = questionStatusRepository.findByQuestionIdAndUserId(questionId, userId);

        if(questionStatus==null){
            throw new QuestionStatusNotFoundException(questionId, userId);
        }

        questionStatus.setNote(newQuestionStatus.getNote());
        questionStatusRepository.save(questionStatus);
        return questionStatus;
    }
}
