package com.scaffolding.repository;

import com.scaffolding.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {


    List<Seat> findSeatsBySid(@Param("sid") Integer sid);
}
