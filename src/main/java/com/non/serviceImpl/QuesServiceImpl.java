package com.non.serviceImpl;

import com.non.exception.ResourceNotFoundException;
import com.non.model.Question;
import com.non.repository.QuestionRepository;
import com.non.service.QuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesServiceImpl implements QuesService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQues(Question question) {
        System.out.println("Question creation in DB is started");
        Question ques = new Question();
        ques.setTitle(question.getTitle());
        ques.setLink(question.getLink());
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQues() {
        System.out.println("Sending all the Questions");
        return questionRepository.findAll();
    }
    @Override
    public Question getQuesById(Integer id){
        System.out.println("Sending Question by Id");
        return questionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Question", "Id", id));
    }
    @Override
    public Question updateQues(Integer id, Question question){
        Question question1 = questionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Question", "Id", id));
        question1.setTitle(question.getTitle());
        question1.setLink(question.getLink());
        return questionRepository.save(question1);
    }
    @Override
    public String deleteQues(Integer id){
        questionRepository.deleteById(id);
        return "Question deleted with id: " + id;
    }
}
