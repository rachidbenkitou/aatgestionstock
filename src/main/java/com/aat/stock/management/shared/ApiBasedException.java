package com.aat.stock.management.shared;

import org.springframework.http.HttpStatus;

public abstract class ApiBasedException extends RuntimeException{

    public ApiBasedException(String message){

        super(message);

    }

    // This abstract function returns the status of the exception like (NO_FOUND, BAD_REQUEST and CONFLICT ...)
    public abstract HttpStatus getStatusCode();

}
