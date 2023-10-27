package com.non.repository;

import com.non.model.QuestionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionStatusRepo extends JpaRepository<QuestionStatus, Integer> {
}
