package com.aat.stock.management.transaction.receptionnaireMatiere.exception;

import com.aat.stock.management.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class ReceptonnaireMatiereQuantityInsufisant extends ApiBasedException {

    public ReceptonnaireMatiereQuantityInsufisant(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
