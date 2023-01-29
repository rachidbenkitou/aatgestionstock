package com.aat.stock.management.filiere.exceptions;

import com.aat.stock.management.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class NomFiliereNotProvided extends ApiBasedException {
    public NomFiliereNotProvided(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
