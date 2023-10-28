package com.non.serviceImpl;

import com.non.exception.ResourceNotFoundException;
import com.non.model.QuestionStatus;
import com.non.repository.QuestionStatusRepo;
import com.non.service.QuesStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesStatusServiceImpl implements QuesStatusService {
    @Autowired
    private QuestionStatusRepo questionStatusRepo;
    @Override
    public QuestionStatus createQuesStatus(QuestionStatus questionStatus) {
        return questionStatusRepo.save(questionStatus);
    }

    @Override
    public List<QuestionStatus> getAllQuesStatus() {
        return questionStatusRepo.findAll();
    }

    @Override
    public QuestionStatus getQuesStatusById(Integer id) {
        return questionStatusRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("QuesStatus", "Id", id));
    }

    @Override
    public QuestionStatus updateQuesStatus(Integer id, QuestionStatus questionStatus) {
        QuestionStatus questionStatus1 = questionStatusRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("QuestionStatus", "Id", id));
        questionStatus1.setStatus(questionStatus.getStatus());
        return questionStatusRepo.save(questionStatus1);
    }

    @Override
    public String deleteQuesStatus(Integer id) {
        questionStatusRepo.deleteById(id);
        return "Question Status is deleted with Id: " + id;
    }
}
