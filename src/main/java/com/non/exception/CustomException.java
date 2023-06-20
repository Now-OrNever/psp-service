package com.non.exception;

import java.io.Serial;

/**
 * PythonAPIException, Runtime exception for the API calls
 *
 * @author bharat.varshney
 */
public class CustomException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}