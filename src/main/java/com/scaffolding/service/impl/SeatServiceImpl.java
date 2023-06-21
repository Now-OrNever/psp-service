package com.scaffolding.service.impl;

import com.scaffolding.model.Seat;
import com.scaffolding.model.Train;
import com.scaffolding.repository.SeatRepository;
import com.scaffolding.repository.TrainRepository;
import com.scaffolding.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    private final TrainRepository trainRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository, TrainRepository trainRepository) {
        this.seatRepository = seatRepository;
        this.trainRepository = trainRepository;
    }

    @Override
    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    @Override
    @Transactional
    public Seat addSeat(Integer tId, Seat seat) {
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
    public List<Seat> findSeats(Integer tid) {
        Optional<Train> trainsOptional = trainRepository.findById(tid);
        if (trainsOptional.isEmpty()) {
            return Collections.emptyList();
        }
        return seatRepository.findSeatsBySid(tid);
    }


}
