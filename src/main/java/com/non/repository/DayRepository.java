package com.non.repository;

import com.non.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayRepository extends JpaRepository<Day, Long> {
    List<Day> findByDidContaining(Long did);
}
