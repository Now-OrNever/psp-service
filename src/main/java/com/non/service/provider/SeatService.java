package com.non.service.provider;

import com.non.model.Seat;

import java.util.List;

public interface SeatService {

    List<Seat> getSeats();

    Seat addSeat(String tId, Seat seat);

    List<Seat> findSeats(String tId);

}