package com.findbook.demo.exception;

public class EmailNotValid extends Exception {

    private static final String DEFAULT_MESSAGE = "The email is not valid";

    public EmailNotValid() {
        super(DEFAULT_MESSAGE);
    }

}