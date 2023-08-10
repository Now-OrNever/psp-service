package com.non.exception;

public class QuestionStatusNotFoundException extends RuntimeException{
    public QuestionStatusNotFoundException(String questionId, String userId){
        super("Data is not found of given questionId "+questionId+" & userId "+userId);
    }
}
