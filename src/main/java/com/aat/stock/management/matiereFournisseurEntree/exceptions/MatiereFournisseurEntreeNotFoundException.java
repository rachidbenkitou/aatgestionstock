package com.aat.stock.management.matiereFournisseurEntree.exceptions;

import com.aat.stock.management.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class MatiereFournisseurEntreeNotFoundException extends ApiBasedException {

    public MatiereFournisseurEntreeNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return  HttpStatus.NOT_FOUND;
    }

}
