package com.non.exception;

public class ResourceNotFoundException extends RuntimeException{

    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %l", resourceName, fieldName, fieldValue));
//		String message = fieldName + " is not found for " + resourceName + " : " + fieldValue;
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue= fieldValue;


    }

}
