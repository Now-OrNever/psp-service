package com.non.serviceImpl;

import com.non.exception.ResourceNotFoundException;
import com.non.model.Question;
import com.non.model.QuestionStatus;
import com.non.repository.QuestionRepository;
import com.non.repository.QuestionStatusRepo;
import com.non.service.QuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesServiceImpl implements QuesService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionStatusRepo questionStatusRepo;

    @Override
    public Question createQues(Question question) {
        Question ques = new Question();
        ques.setTitle(question.getTitle());
        ques.setLink(question.getLink());
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQues() {
        return questionRepository.findAll();
    }
    @Override
    public Question getQuesById(Integer id){
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

    @Override
    public String updateQuesStatus(Integer quesId, Integer statusId){
        Question question = questionRepository.findById(quesId).orElse(null);
        if(question == null) throw new ResourceNotFoundException("Question", "Question-Id", quesId);
        QuestionStatus questionStatus = questionStatusRepo.findById(statusId).orElse(null);
        if(questionStatus == null) throw new ResourceNotFoundException("Question-Status", "Status-Id", statusId);
        question.getQuestionStatus().add(questionStatus);
        questionRepository.save(question);
        return "Question status is updated successfully";
    }
}
