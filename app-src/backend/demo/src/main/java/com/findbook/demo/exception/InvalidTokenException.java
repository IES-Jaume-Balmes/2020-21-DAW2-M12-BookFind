package com.findbook.demo.exception;

public class InvalidTokenException extends Exception {

    private static final String DEFAULT_MESSAGE = "TOKEN ERROR";
    /*   private String errorMessage;*/
    private Exception exception;

    public InvalidTokenException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidTokenException(String error) {
        super(error);
        /*   this.errorMessage = error;*/

    }

    public InvalidTokenException(String error, Exception exception) {
        super(error);
        this.exception = exception;


    }
}