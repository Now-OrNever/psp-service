package com.non.controller;

import com.non.model.Train;
import com.non.service.provider.TrainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("trains")
public class TrainController {

    @Autowired
    private TrainsService trainCheckingService;

    @GetMapping("/test")
    public String home() {
        return "Welcome to train checking";
    }

    //Find All Trains
    @GetMapping
    public List<Train> getTrains() {
        return trainCheckingService.getTrains();
    }

    //Find Trains by Tid
    @GetMapping(value = "/{tid}")
    public Optional<Train> getTrainsById(@PathVariable String tid) {
        return trainCheckingService.getTrainsById(tid);
    }

    //Find Trains from particular source
    @GetMapping(value = "find/{source}/{destination}")
    public List<Train> getTrains(@PathVariable String source, @PathVariable String destination) {
        return trainCheckingService.getTrains(source, destination);
    }

    //Add train
    @PostMapping
    public Train addTrain(@RequestBody Train train) {
        return trainCheckingService.addTrain(train);
    }

    //Update train by tid
    @PutMapping
    public Train updateTrain(@RequestBody Train train) {
        return trainCheckingService.updateTrain(train);
    }

    //Delete train by tid
    @DeleteMapping(value = "/{tid}")
    public String delete(@PathVariable String tid) {
        return trainCheckingService.deleteTrain(tid);
    }

}
