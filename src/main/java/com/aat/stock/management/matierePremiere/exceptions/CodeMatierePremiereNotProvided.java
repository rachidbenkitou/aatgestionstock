package com.aat.stock.management.matierePremiere.exceptions;

import com.aat.stock.management.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class CodeMatierePremiereNotProvided extends ApiBasedException {

    public CodeMatierePremiereNotProvided(String message){
        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
