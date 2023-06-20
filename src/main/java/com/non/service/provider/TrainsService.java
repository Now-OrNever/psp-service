package com.non.service.provider;

import com.non.model.Train;

import java.util.List;
import java.util.Optional;

public interface TrainsService {

    List<Train> getAllTrains();

    List<Train> getAllTrains(String source, String destination);

    Train addTrain(Train train);

    Optional<Train> getTrainsById(String tid);

    String deleteTrain(String tid);

    Train updateTrain(Train train);

}
