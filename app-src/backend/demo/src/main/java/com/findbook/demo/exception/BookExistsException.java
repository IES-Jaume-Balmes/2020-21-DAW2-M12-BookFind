package com.findbook.demo.exception;

public class BookExistsException extends Exception {
    private static final String DEFAULT_MESSAGE = "The book already exists";

    public BookExistsException() {
        super(DEFAULT_MESSAGE);
    }

}