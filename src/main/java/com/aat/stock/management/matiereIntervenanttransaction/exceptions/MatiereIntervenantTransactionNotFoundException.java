package com.aat.stock.management.matiereIntervenanttransaction.exceptions;

import com.aat.stock.management.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class MatiereIntervenantTransactionNotFoundException extends ApiBasedException {
    public MatiereIntervenantTransactionNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return  HttpStatus.NOT_FOUND;
    }

}
