package com.aat.stock.management.matiereReceptionSortie.exceptions;

import com.aat.stock.management.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class MatiereReceptionnaireSortieNotFoundException extends ApiBasedException {

    public MatiereReceptionnaireSortieNotFoundException(String message) {

        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return  HttpStatus.NOT_FOUND;
    }

}
