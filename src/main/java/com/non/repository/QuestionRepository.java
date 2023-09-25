package com.non.repository;

import com.non.model.Question;
import com.non.model.QuestionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, String> {

    List <Question> findByQuestionId(String questionId);
}
