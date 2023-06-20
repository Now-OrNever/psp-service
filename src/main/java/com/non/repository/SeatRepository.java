package com.non.repository;

import com.non.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, String> {


    List<Seat> findSeatsByTid(@Param("tId") String tId);
}
