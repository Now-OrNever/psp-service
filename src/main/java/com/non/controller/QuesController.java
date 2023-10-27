package com.non.controller;

import com.non.model.Question;
import com.non.service.QuesService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/q")
    List<Question> getAllQues(){
        System.out.println("All Questions GET Resquest");
        return quesService.getAllQues();
    }

    @GetMapping("/{id}")
    Question getAllQues(@PathVariable Integer id){
        System.out.println("Question GET Request by Id");
        return quesService.getQuesById(id);
    }

    @PostMapping("/pq")
    Question setQues(@RequestBody Question question){
        System.out.println("Question POST Request");
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

}
