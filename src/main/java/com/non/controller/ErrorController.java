package com.non.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // This method is no longer used for handling errors
        return "errorPage"; // Provide an appropriate error page view name
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception ex) {
        // Handle specific exception types and return a custom error message
        return "Custom error message: " + ex.getMessage();
    }
}
