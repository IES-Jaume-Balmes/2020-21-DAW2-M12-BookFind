package com.findbook.demo.exception;

public class ErrorSavingFile extends Exception {

    private static final String DEFAULT_MESSAGE = "something happened while trying to save the file";

    public ErrorSavingFile() {
        super(DEFAULT_MESSAGE);
    }

    public ErrorSavingFile(String message) {
        super(message);
    }
}