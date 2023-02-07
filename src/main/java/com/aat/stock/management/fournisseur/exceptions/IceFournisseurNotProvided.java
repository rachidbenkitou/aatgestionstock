package com.aat.stock.management.fournisseur.exceptions;

import com.aat.stock.management.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class IceFournisseurNotProvided extends ApiBasedException {
    public IceFournisseurNotProvided(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
