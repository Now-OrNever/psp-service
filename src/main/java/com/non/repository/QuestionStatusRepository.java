package com.non.repository;

import com.non.model.QuestionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionStatusRepository extends CrudRepository<QuestionStatus, Long> {
    QuestionStatus findByQuestionIdAndUserId(String questionId, String userId);

    List <QuestionStatus> findByQuestionId(String questionId);

}
