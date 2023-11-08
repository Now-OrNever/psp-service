package com.non.controller;

import com.non.dto.QuesDto;
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
    List<QuesDto> getAllQues(){
        return quesService.getAllQues();
    }

    @GetMapping("/{id}")
    QuesDto getQues(@PathVariable Integer id){
        return quesService.getQuesById(id);
    }

    @PostMapping("/")
    QuesDto setQues(@RequestBody QuesDto quesDto){
        return this.quesService.createQues(quesDto);
    }

    @PutMapping("/{id}")
    QuesDto updateQuestion(@PathVariable Integer id, @RequestBody QuesDto quesDto){
        return quesService.updateQues(id, quesDto, null);
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
