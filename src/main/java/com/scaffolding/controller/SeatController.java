package com.scaffolding.controller;

import com.scaffolding.exception.ApiException;
import com.scaffolding.model.Seat;
import com.scaffolding.service.SeatService;
import com.scaffolding.util.PlatformConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = PlatformConstants.ACCESS_CONTROL_ALLOW_ORIGIN_VALUE, allowedHeaders = PlatformConstants.ACCESS_CONTROL_ALLOW_ORIGIN_VALUE)
@RequestMapping("/seats")
public class SeatController {
    private static final Logger logger = LoggerFactory.getLogger(SeatController.class);


    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getSeats() {
        return seatService.getSeats();
    }

    //Find seats of a particular train
    @GetMapping("/{tid}")
    public List<Seat> findSeats(@PathVariable Integer tid) {
        return seatService.findSeats(tid);
    }

    //Add seats into a train
    @PostMapping("/{tid}")
    public ResponseEntity<Seat> addSeat(@PathVariable Integer tid, @RequestBody Seat seat) {
        try {
            logger.info("The tid is: {}", tid);
            return ResponseEntity.ok(seatService.addSeat(tid, seat));
        } catch (ApiException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @PutMapping("/{tid}")
    public Seat updateSeats(@PathVariable Integer tid, @RequestBody Seat seat) {
        return seatService.addSeat(tid, seat);
    }

}