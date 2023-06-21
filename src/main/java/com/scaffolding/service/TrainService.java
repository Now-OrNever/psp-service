package com.scaffolding.service;

import com.scaffolding.model.Train;

import java.util.List;
import java.util.Optional;

public interface TrainService {

    List<Train> getTrainsBySourceAndDestination();

    List<Train> getTrainsBySourceAndDestination(String source, String destination);

    Train addTrain(Train train);

    Optional<Train> getTrainsById(String tid);

    String deleteTrain(String tid);

    Train updateTrain(Train train);

}
