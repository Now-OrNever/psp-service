package com.non.repository;

import com.non.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {


    List<Seat> findSeatsBySid(@Param("sid") String sid);
}
