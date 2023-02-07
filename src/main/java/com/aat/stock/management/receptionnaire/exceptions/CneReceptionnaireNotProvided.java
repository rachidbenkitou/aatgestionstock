package com.aat.stock.management.receptionnaire.exceptions;

import com.aat.stock.management.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class CneReceptionnaireNotProvided extends ApiBasedException {
    public CneReceptionnaireNotProvided(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
