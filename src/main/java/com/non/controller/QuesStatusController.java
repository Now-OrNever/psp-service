package com.non.controller;

import com.non.model.QuestionStatus;
import com.non.service.QuesStatusService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
@RequestMapping("/ques-status/")
public class QuesStatusController {
    @Autowired
    QuesStatusService quesStatusService;

    @PostMapping("/")
    QuestionStatus setQuesStatus(@RequestBody QuestionStatus questionStatus){
        return quesStatusService.createQuesStatus(questionStatus);
    }

    @GetMapping("/")
    List<QuestionStatus> getAllQuesStatus(){
        return quesStatusService.getAllQuesStatus();
    }

    @GetMapping("/{id}")
    QuestionStatus getQuesStatus(@PathVariable Integer id){
        return quesStatusService.getQuesStatusById(id);
    }

    @PutMapping("/{id}")
    QuestionStatus updateQuesStatus(@PathVariable Integer id, @RequestBody QuestionStatus questionStatus){
        return quesStatusService.updateQuesStatus(id, questionStatus);
    }

    @DeleteMapping("/{id}")
    String deleteQuesStatus(@PathVariable Integer id){
        return quesStatusService.deleteQuesStatus(id);
    }

}
