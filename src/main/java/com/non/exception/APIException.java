package com.non.exception;

import java.io.Serial;

/**
 * PythonAPIException, Runtime exception for the API calls
 *
 * @author bharat.varshney
 */
public class APIException extends RuntimeException {

    @Serial
	private static final long serialVersionUID = 1L;

    public APIException(String message) {
        super(message);
    }

    public APIException(String message, Throwable cause) {
        super(message, cause);
    }
}