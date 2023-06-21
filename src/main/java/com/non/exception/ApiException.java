package com.non.exception;

import java.io.Serial;

/**
 * PythonAPIException, Runtime exception for the API calls
 *
 * @author bharat.varshney
 */
public class ApiException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}