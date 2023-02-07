package com.aat.stock.management.matiereIntervenanttransaction.exceptions;

import com.aat.stock.management.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class InsufficientQuantityException extends ApiBasedException {
    public InsufficientQuantityException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return null;
    }
}
