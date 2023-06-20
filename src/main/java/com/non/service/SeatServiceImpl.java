package com.non.service;

import com.non.model.Seat;
import com.non.model.Train;
import com.non.repository.SeatRepository;
import com.non.repository.TrainRepository;
import com.non.service.provider.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SeatServiceImpl implements SeatsService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Seat addSeat(String tId, Seat seat) {
        Optional<Train> trainsOptional = trainRepository.findById(tId);
        if (trainsOptional.isEmpty()) {
            return null;
        }
        Train train = trainsOptional.get();
        seat.setTrain(train);
        seatRepository.save(seat);

        return seat;
    }

    @Override
    public List<Seat> findSeats(String tId) {
        Optional<Train> trainsOptional = trainRepository.findById(tId);
        if (trainsOptional.isEmpty()) {
            return Collections.emptyList();
        }
        return seatRepository.findSeatsByTid(tId);
    }


}