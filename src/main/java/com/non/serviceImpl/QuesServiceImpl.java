package com.non.serviceImpl;

import com.non.dto.CardDto;
import com.non.dto.QuesDto;
import com.non.exception.ResourceNotFoundException;
import com.non.model.Card;
import com.non.model.Question;
import com.non.model.QuestionStatus;
import com.non.repository.QuestionRepository;
import com.non.repository.QuestionStatusRepo;
import com.non.service.QuesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuesServiceImpl implements QuesService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionStatusRepo questionStatusRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuesDto createQues(QuesDto quesDto) {
        return this.modelMapper.map(questionRepository.save(
                this.modelMapper.map(quesDto, Question.class)), QuesDto.class
        );
    }

    @Override
    public List<QuesDto> getAllQues() {
        List<Question> questions = questionRepository.findAll();
        List<QuesDto> quesDtos = new ArrayList<>();
        for(Question question:questions){
            quesDtos.add(
                    this.modelMapper.map(question, QuesDto.class)
            );
        }
        return quesDtos;
    }
    @Override
    public QuesDto getQuesById(Integer id){
        Question question = questionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Question", "Id", id));
        return this.modelMapper.map(question, QuesDto.class);
    }
    @Override
    public QuesDto updateQues(Integer id, QuesDto quesDto, CardDto cardDto){
        Question question = questionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Question", "Id", id));
        if(quesDto != null){
            question.setTitle(quesDto.getTitle());
            question.setLink(quesDto.getLink());
        }
        if(cardDto != null) {
            question.getCards().add(this.modelMapper.map(cardDto, Card.class));
            // saving ques in card is removed because of Cascade.ALL but didn't cross verified
        }
        return this.modelMapper.map(questionRepository.save(question), QuesDto.class);
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
