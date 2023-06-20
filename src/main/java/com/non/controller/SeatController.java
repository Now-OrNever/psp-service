package com.non.controller;

import com.non.model.Seat;
import com.non.service.provider.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("seats")
public class SeatController {

    @Autowired
    private SeatsService ticketBookingService;

    @GetMapping(value = "/test")
    public String home() {
        return "Welcome to Ticket Booking";
    }

    //Find all Seats
    @GetMapping
    public List<Seat> getSeats() {
        return ticketBookingService.getSeats();
    }

    //Find seats of a particular train
    @GetMapping(value = "/{tid}")
    public List<Seat> findSeats(@PathVariable String tid) {
        return ticketBookingService.findSeats(tid);
    }

    //Add seats into a train
    @PostMapping(value = "/{tid}")
    public Seat addSeat(@PathVariable String tid, @RequestBody Seat seat) {
        return ticketBookingService.addSeat(tid, seat);
    }

    @PutMapping(value = "/{tid}")
    public Seat updateSeats(@PathVariable String tid, @RequestBody Seat seat) {
        return ticketBookingService.addSeat(tid, seat);
    }

}
