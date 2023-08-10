package com.non.controller;


import com.non.exception.DayNotFoundException;
import com.non.exception.QuestionNotFoundException;
import com.non.model.Day;
import com.non.model.Question;
import com.non.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/non/question")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/{questionId}")
    public Question findQuestion(@PathVariable String questionId){ return questionRepository.findById(questionId).orElse(null);}

    @PutMapping("/{questionId}")
    public Question updateQuestion(@RequestBody Question newQuestion ,@PathVariable String questionId){
        return questionRepository.findById(questionId)
                .map(question -> {
                    question.setQuestionName(newQuestion.getQuestionName());
                    question.setQuestionLink(newQuestion.getQuestionLink());
                    question.setTags(newQuestion.getTags());
                    return questionRepository.save(question);
                }).orElseThrow(()->new QuestionNotFoundException(questionId));
    }

    @DeleteMapping("deleteQuestion/{questionId}")
    public String deleteQuestion(@PathVariable("questionId") String questionId){
        // Get the day from the database by its ID.
        Question question = questionRepository.findById(questionId).orElseThrow(()->new QuestionNotFoundException(questionId));

        // Delete the day from the database.
        questionRepository.delete(question);

        // Return a success message.
        return "Question deleted";
    }


}
