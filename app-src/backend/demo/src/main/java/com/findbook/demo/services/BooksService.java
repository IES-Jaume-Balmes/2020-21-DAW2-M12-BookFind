package com.findbook.demo.services;

import com.findbook.demo.dao.BookRepository;
import com.findbook.demo.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    BookRepository bookRepository;

    public Optional<Book> findOne(Long productId) {
        Optional<Book> bookInfo = bookRepository.findById(productId);
        return bookInfo;
    }

    public Page<Book> getBooks(Pageable page) {
        return bookRepository.findAll(page);
    }


}
