package com.non.controller;


import com.non.exception.QuestionStatusNotFoundException;
import com.non.model.Question;
import com.non.model.QuestionStatus;
import com.non.repository.QuestionRepository;
import com.non.repository.QuestionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/non/questionstatus")
@CrossOrigin("http://localhost:3000")
public class QuestionStatusController {

    @Autowired
    QuestionStatusRepository questionStatusRepository;

    @Autowired
    QuestionRepository questionRepository;

    public QuestionStatusController(QuestionStatusRepository questionStatusRepository, QuestionRepository questionRepository) {
        this.questionStatusRepository = questionStatusRepository;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/{questionId}/{userId}")
    public QuestionStatus findQuestionStatus(@PathVariable String questionId, @PathVariable String userId) {
        QuestionStatus questionStatus = questionStatusRepository.findByQuestionIdAndUserId(questionId, userId);
        if (questionStatus == null) {
            questionStatus = new QuestionStatus();
            questionStatus.setQuestionId(questionId);
            questionStatus.setUserId(userId);
            questionStatus.setStatus("Pending");
            questionStatusRepository.save(questionStatus);
        }

        return questionStatus;
    }

//    @GetMapping("combine/{userId}")
//    public List <QuestionStatus> findAllQuestionStatusOfUserId(@PathVariable String userId){
//        List <QuestionStatus> questionStatuses = questionStatusRepository.findByUserId(userId);
//        List < Question > questions = questionRepository.findAll();
//        List<QuestionStatusDto> questionStatusDtos = new ArrayList<>();
//    }

    @GetMapping("/{userId}")
    public List <QuestionStatus> findQuestionStatusByUserId(@PathVariable String userId){
        List <QuestionStatus> questionStatuses = questionStatusRepository.findByUserId(userId);
        return questionStatuses;
    }

    @PutMapping("/statusUpdate/{questionId}/{userId}")
    public QuestionStatus updateQuestionStatus(@RequestBody QuestionStatus newQuestionStatus, @PathVariable String questionId, @PathVariable String userId) {
        QuestionStatus questionStatus = questionStatusRepository.findByQuestionIdAndUserId(questionId, userId);

        if (questionStatus == null) {
            throw new QuestionStatusNotFoundException(questionId, userId);
        }

        questionStatus.setStatus(newQuestionStatus.getStatus());
        questionStatusRepository.save(questionStatus);
        return questionStatus;
    }

    @PutMapping("/noteUpdate/{questionId}/{userId}")
    public QuestionStatus updateNote(@RequestBody QuestionStatus newQuestionStatus, @PathVariable String questionId, @PathVariable String userId) {
        QuestionStatus questionStatus = questionStatusRepository.findByQuestionIdAndUserId(questionId, userId);

        if (questionStatus == null) {
            throw new QuestionStatusNotFoundException(questionId, userId);
        }

        questionStatus.setApproach(newQuestionStatus.getApproach());
        questionStatus.setMemoryComplexity(newQuestionStatus.getMemoryComplexity());
        questionStatus.setTimeComplexity(newQuestionStatus.getTimeComplexity());
        questionStatus.setNote(newQuestionStatus.getNote());
        questionStatus.setDifficultyLevel(newQuestionStatus.getDifficultyLevel());
        questionStatusRepository.save(questionStatus);
        return questionStatus;
    }

    @DeleteMapping("/delete/{questionId}")
    public String deleteQuestionStatus(@PathVariable("questionId") String questionId) {
        List<QuestionStatus> questionStatus = questionStatusRepository.findByQuestionId(questionId);
        if (questionStatus != null) {
            questionStatusRepository.deleteAll(questionStatus);
        }
        return "Data deleted";
    }

}
