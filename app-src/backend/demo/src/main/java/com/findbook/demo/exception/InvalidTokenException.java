package com.findbook.demo.exception;

public class InvalidTokenException extends Exception {

    private static final String DEFAULT_MESSAGE = "TOKEN ERROR";
    /*   private String errorMessage;*/
    private RuntimeException exception;

    public InvalidTokenException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidTokenException(String error) {
        super(error);
        /*   this.errorMessage = error;*/

    }

    public InvalidTokenException(String error, RuntimeException exception) {
        super(error);
        this.exception = exception;


    }
}