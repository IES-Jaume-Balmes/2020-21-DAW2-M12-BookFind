package com.findbook.demo.dao;

import com.findbook.demo.entities.Book;
import com.findbook.demo.exception.NotEnoughProductsInStockException;

import java.util.Map;

public interface

ShoppingCartRepository {

    void addBook(Book book);

    void removeProduct(Book book);

    Map<Book, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;
}
