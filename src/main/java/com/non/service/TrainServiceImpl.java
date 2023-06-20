package com.non.service;

import com.non.model.Train;
import com.non.repository.TrainRepository;
import com.non.service.provider.TrainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrainServiceImpl implements TrainsService {

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public List<Train> getTrains() {
        return trainRepository.findAll();
    }

    @Override
    public List<Train> getTrains(String source, String destination) {
        return trainRepository.findBySource(source, destination);
    }

    @Override
    public Train addTrain(Train train) {
        trainRepository.save(train);
        return train;
    }

    @Override
    public Train updateTrain(Train train) {
        Optional<Train> trainsOptional = trainRepository.findById(train.getTid());
        if (trainsOptional.isEmpty()) {
            return null;
        }
        trainRepository.save(train);
        return train;
    }

    @Override
    public Optional<Train> getTrainsById(String tid) {
        return trainRepository.findById(tid);
    }

    @Override
    public String deleteTrain(String tid) {
        trainRepository.deleteById(tid);
        return "Train deleted";
    }
}