package com.non.controller;

import com.non.exception.APIException;
import com.non.model.Seat;
import com.non.service.provider.SeatsService;
import com.non.util.PlatformConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = PlatformConstant.ACCESS_CONTROL_ALLOW_ORIGIN_VALUE, allowedHeaders = PlatformConstant.ACCESS_CONTROL_ALLOW_ORIGIN_VALUE)

@RequestMapping("seats")
public class SeatController {
    private static final Logger logger = LoggerFactory.getLogger(SeatController.class);


    private final SeatsService seatsService;

    @Autowired
    public SeatController(SeatsService seatsService) {
        this.seatsService = seatsService;
    }

    @GetMapping
    public List<Seat> getSeats() {
        return seatsService.getSeats();
    }

    //Find seats of a particular train
    @GetMapping(value = "/{tid}")
    public List<Seat> findSeats(@PathVariable String tid) {
        return seatsService.findSeats(tid);
    }

    //Add seats into a train
    @PostMapping(value = "/{tid}")
    public ResponseEntity<Seat> addSeat(@PathVariable String tid, @RequestBody Seat seat) {
        try {
            logger.info("the tid is:{}", tid);
            return ResponseEntity.ok(seatsService.addSeat(tid, seat));
        } catch (APIException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @PutMapping(value = "/{tid}")
    public Seat updateSeats(@PathVariable String tid, @RequestBody Seat seat) {
        return seatsService.addSeat(tid, seat);
    }

}
