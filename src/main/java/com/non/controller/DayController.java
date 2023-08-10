package com.non.controller;


import com.non.exception.DayNotFoundException;
import com.non.model.Day;
import com.non.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/non/day")
public class DayController {
    @Autowired
    private DayRepository dayRepository;

    public DayController(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @PostMapping
    public Day saveDay(@RequestBody Day day){return dayRepository.save(day);}

    @GetMapping
    public List<Day> findAllDay() {return dayRepository.findAll();}

    @GetMapping("/{did}")
    public Day findDay(@PathVariable Long did){return dayRepository.findById(did).orElse(null);}

    @PutMapping("addQuestion/{did}")
    public Day updateDay(@RequestBody Day newDay, @PathVariable Long did){
        return dayRepository.findById(did)
                .map(day -> {
                    day.setTotalQuestion(newDay.getTotalQuestion());
                    day.setQuestions(newDay.getQuestions());
                    return dayRepository.save(day);
                }).orElseThrow(()->new DayNotFoundException(did));
    }
    @PutMapping("topicName/{did}")
    public Day updateTopicName(@RequestBody Day newDay, @PathVariable Long did){
        return dayRepository.findById(did)
                .map(day -> {
                    day.setTopic(newDay.getTopic());
                    return dayRepository.save(day);
                }).orElseThrow(()->new DayNotFoundException(did));
    }

    @DeleteMapping("deleteDay/{did}")
    public String deleteDay(@PathVariable("did") Long did){
        // Get the day from the database by its ID.
        Day day = dayRepository.findById(did).orElseThrow(()->new DayNotFoundException((did)));

        // Delete the day from the database.
        dayRepository.delete(day);

        // Return a success message.
        return "File deleted";
    }

}
