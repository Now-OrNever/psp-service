package com.non.exception;

public class DayNotFoundException extends RuntimeException {
    public DayNotFoundException(Long id){
        super("Could not found the day "+id);
    }
}
