package com.non.controller;

import com.non.model.Train;
import com.non.service.provider.TrainsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("trains")
public class TrainController {

    private final TrainsService trainsService;

    public TrainController(TrainsService trainsService) {
        this.trainsService = trainsService;
    }

    @GetMapping("/test")
    public String home() {
        return "Welcome to train checking";
    }

    //Find All Trains
    @GetMapping
    public List<Train> getTrains() {
        return trainsService.getTrains();
    }

    //Find Trains by Tid
    @GetMapping(value = "/{tid}")
    public Optional<Train> getTrainsById(@PathVariable String tid) {
        return trainsService.getTrainsById(tid);
    }

    //Find Trains from particular source
    @GetMapping(value = "find/{source}/{destination}")
    public List<Train> getTrains(@PathVariable String source, @PathVariable String destination) {
        return trainsService.getTrains(source, destination);
    }

    //Add train
    @PostMapping
    public Train addTrain(@RequestBody Train train) {
        return trainsService.addTrain(train);
    }

    //Update train by tid
    @PutMapping
    public Train updateTrain(@RequestBody Train train) {
        return trainsService.updateTrain(train);
    }

    //Delete train by tid
    @DeleteMapping(value = "/{tid}")
    public String delete(@PathVariable String tid) {
        return trainsService.deleteTrain(tid);
    }

}
