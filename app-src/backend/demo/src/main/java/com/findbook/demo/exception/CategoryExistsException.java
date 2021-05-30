package com.findbook.demo.exception;

public class CategoryExistsException extends Exception {

    private static final String DEFAULT_MESSAGE = "The category is not valid";

    public CategoryExistsException() {
        super(DEFAULT_MESSAGE);
    }

    public CategoryExistsException(String msj) {
        super(msj);
    }
}
