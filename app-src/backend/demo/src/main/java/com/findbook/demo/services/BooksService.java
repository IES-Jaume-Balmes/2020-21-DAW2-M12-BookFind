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
    @Autowired
    BookRepository bookRepository;

    public Optional<Book> findOne(Long productId) {
        Optional<Book> bookInfo = bookRepository.findById(productId);
        return bookInfo;
    }

    public Page<Book> getBooks(Pageable page) {
        return bookRepository.findAll(page);
    }

    //TODO: Validation
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
    /*    @PostMapping("/new")
    public ResponseEntity create(@RequestBody Book product, BindingResult bindingResult) {
        Optional<Book> bookExist = booksService.findOne(product.getBookId());
        if (bookExist != null) {
            bindingResult
                    .rejectValue("bookId", "error.product",
                            "There is already a product with the code provided");
        }
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }
        booksService.save(product);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }*/

}
