package com.aat.stock.management.shared.handlers;

interface ErrorDetailsFactory {
    //This Interface is created to respect dependency injection and inversion of control.
    //In ApiExceptionHandller depends to ErrorDetails class, so we don't create an object with the classique methode
    // like this "ErrorDetails errorDetials= new ErrorDetails(String message, String url)" because it does not
    // respect dependency injection and inversion of control, so to instatiate our class in AppiExceptionHandller
    // we will instantiate it using this method, that's the exemple:
    //ErrorDetails errorDetials=e.createErrorDetails("The article doesn't exist", "The article doesn't exist")
    ErrorDetails createErrorDetails(String message, String description);
}