package com.non.service;

import com.non.model.Trains;
import com.non.repository.TrainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrainsServiceimpl implements TrainsService {

    @Autowired
    private TrainsRepository trainsCheckingRepository;

    public TrainsServiceimpl() {
    }

    @Override
    public List<Trains> getTrains() {
        return trainsCheckingRepository.findAll();
    }

    @Override
    public List<Trains> getTrains(String source, String destination) {
        return trainsCheckingRepository.findBySource(source, destination);
    }

    @Override
    public Trains addTrain(Trains trains) {
        trainsCheckingRepository.save(trains);
        return trains;
    }

    @Override
    public Trains updateTrain(Trains trains) {
        Optional<Trains> trainsOptional = trainsCheckingRepository.findById(trains.getTid());
        if (trainsOptional.isEmpty()) {
            return null;
        }
        trainsCheckingRepository.save(trains);
        return trains;
    }

    @Override
    public Optional<Trains> getTrainsById(String tid) {
        return trainsCheckingRepository.findById(tid);
    }

    @Override
    public String deleteTrain(String tid) {
        trainsCheckingRepository.deleteById(tid);
        return "Train deleted";
    }
}
