package com.scaffolding.repository;

import com.scaffolding.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, String> {

    @Query(value = "select * from train t where t.source = :source and t.destination= :destination", nativeQuery = true)
    List<Train> findBySource(@Param("source") String source, @Param("destination") String destination);


}