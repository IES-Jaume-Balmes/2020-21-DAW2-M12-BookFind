package com.findbook.demo.exception;

public class EmailExistsException extends Exception {
    private static final String DEFAULT_MESSAGE = "The email already exists";

    public EmailExistsException() {
        super(DEFAULT_MESSAGE);
    }

/*    public NotEnoughProductsInStockException(Book book) {
        super(String.format("Not enough %s products in stock. Only %d left", book.getTitle(), book.getQuantity()));
    }*/
}