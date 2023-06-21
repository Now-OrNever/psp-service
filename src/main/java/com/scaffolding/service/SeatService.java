package com.scaffolding.service;

import com.scaffolding.model.Seat;

import java.util.List;

public interface SeatService {

    List<Seat> getSeats();

    Seat addSeat(Integer tId, Seat seat);

    List<Seat> findSeats(Integer tId);

}
