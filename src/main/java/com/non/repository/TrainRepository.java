package com.non.repository;

import com.non.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, String> {

    @Query(value = "select * from train t where t.source = :source and t.destination= :destination", nativeQuery = true)
    List<Train> findBySource(@Param("source") String source, @Param("destination") String destination);


}