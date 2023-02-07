package com.aat.stock.management.matierePremiere.exceptions;

import com.aat.stock.management.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class MatierePremiereAlreadyExistsException extends ApiBasedException {

    public MatierePremiereAlreadyExistsException(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
