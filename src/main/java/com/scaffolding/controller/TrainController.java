package com.scaffolding.controller;

import com.scaffolding.exception.CustomException;
import com.scaffolding.model.Train;
import com.scaffolding.service.TrainService;
import com.scaffolding.util.PlatformConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = PlatformConstants.ACCESS_CONTROL_ALLOW_ORIGIN_VALUE, allowedHeaders = PlatformConstants.ACCESS_CONTROL_ALLOW_ORIGIN_VALUE)
@RequestMapping("/trains")
public class TrainController {
    private static final Logger logger = LoggerFactory.getLogger(TrainController.class);

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    //Find All Trains
    @GetMapping
    public ResponseEntity<List<Train>> getTrainsBySourceAndDestination() {
        try {
            logger.info("The tid is");
            return ResponseEntity.ok(trainService.getTrainsBySourceAndDestination());
        } catch (CustomException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    //Find Trains by Tid
    @GetMapping("/{tid}")
    public Optional<Train> getTrainsById(@PathVariable String tid) {
        return trainService.getTrainsById(tid);
    }

    //Find Trains from particular source
    @GetMapping("/{source}/{destination}")
    public List<Train> getTrainsBySourceAndDestination(@PathVariable String source, @PathVariable String destination) {
        return trainService.getTrainsBySourceAndDestination(source, destination);
    }

    //Add train
    @PostMapping
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

    //Update train by tid
    @PutMapping
    public Train updateTrain(@RequestBody Train train) {
        return trainService.updateTrain(train);
    }

    //Delete train by tid
    @DeleteMapping("/{tid}")
    public String delete(@PathVariable String tid) {
        return trainService.deleteTrain(tid);
    }

}
