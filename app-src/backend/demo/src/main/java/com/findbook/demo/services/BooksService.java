package com.findbook.demo.services;

import com.findbook.demo.dao.BookRepository;
import com.findbook.demo.entities.Book;
import com.findbook.demo.exception.BookExistsException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BooksService {
    //TODO: Validation --> github proyect example (ALL CRUD CONTROLLERS/METHODS)
    @Autowired
    BookRepository bookRepository;

    public Optional<Book> findOne(Long productId) {
        Optional<Book> bookInfo = bookRepository.findById(productId);
        return bookInfo;
    }

    public Page<Book> getBooks(Pageable page) {
        return bookRepository.findAll(page);
    }


    @SneakyThrows
    public ResponseEntity createBook(Book book) {
        //TODO: Find by isbn
        boolean bookExists = bookRepository.findById(book.getBookId()).isPresent();
        if (bookExists) {
            throw new BookExistsException();
        }
        bookRepository.save(book);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @SneakyThrows
    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getBookId()).orElse(null);
        if (existingBook == null) throw new BookExistsException("The book you'ere trying to edit does not exists");
        existingBook.setIsbn(book.getIsbn());
        existingBook.setImage(book.getImage());
        existingBook.setTitle(book.getTitle());
        existingBook.setPublishedDate(book.getPublishedDate());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        existingBook.setPrice(book.getPrice());
        return bookRepository.save(existingBook);
    }

    public ResponseEntity deleteBook(Long id) {
        bookRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
