package com.non.exception;

public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException(String id){
        super("Could not found the question with id "+id);
    }
}
