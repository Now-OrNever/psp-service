package com.non.controller;

import com.non.model.Question;
import com.non.service.QuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
@RequestMapping("/question")
public class QuesController {
    private final QuesService quesService;

    @Autowired
    public QuesController(QuesService quesService) {
        this.quesService = quesService;
    }

    @GetMapping("/")
    List<Question> getAllQues(){
        return quesService.getAllQues();
    }

    @GetMapping("/{id}")
    Question getQues(@PathVariable Integer id){
        return quesService.getQuesById(id);
    }

    @PostMapping("/")
    Question setQues(@RequestBody Question question){
        return this.quesService.createQues(question);
    }

    @PutMapping("/{id}")
    Question updateQuestion(@PathVariable Integer id, @RequestBody Question question){
        return quesService.updateQues(id, question);
    }

    @DeleteMapping("{id}")
    String deleteQues(@PathVariable Integer id){
        return quesService.deleteQues(id);
    }

    @PutMapping("/{quesId}/{statusId}")
    ResponseEntity<String> updateQuesStatus(@PathVariable Integer quesId, @PathVariable Integer statusId){
        return new ResponseEntity<>(quesService.updateQuesStatus(quesId, statusId), HttpStatus.ACCEPTED);
    }

}
