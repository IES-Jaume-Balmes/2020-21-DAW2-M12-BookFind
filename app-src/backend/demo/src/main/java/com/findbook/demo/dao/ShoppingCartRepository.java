package com.findbook.demo.dao;

import com.findbook.demo.entities.Book;
import com.findbook.demo.entities.Cart;
import com.findbook.demo.exception.NotEnoughProductsInStockException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ShoppingCartRepository extends JpaRepository<Cart, Long> {
/*
    void addBook(Book book);

    void removeProduct(Book book);

    Map<Book, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;*/
}
