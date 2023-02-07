package com.aat.stock.management.shared.handlers;

import org.springframework.stereotype.Service;


@Service
class ErrorDetailsFactoryImpl implements ErrorDetailsFactory {

    // Go to ErrorDetailsFactory Interface for an explanation of what this method is for
    @Override
    public ErrorDetails createErrorDetails(String message, String description) {
        return new ErrorDetails(message, description);

    }

}