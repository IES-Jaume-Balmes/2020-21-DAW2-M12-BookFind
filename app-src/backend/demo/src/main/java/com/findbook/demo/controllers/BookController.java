package com.findbook.demo.controllers;

import com.findbook.demo.dao.BookRepository;
import com.findbook.demo.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("bookfind")
public class BookController {
    /**
     * Dependency injection
     */
    @Autowired
    BookRepository bookCrud;

/*
//This is mvc, in rest api do not work
    @GetMapping("/new")
    public String displayBookForm(Model model) {
        Book nouBook = new Book();
        model.addAttribute("book", nouBook);
        return " ";


    }*/

    @PostMapping("/save")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        if (book != null) {
            bookCrud.save(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //mostrar todos los libros añadidos
    @GetMapping("/show")
    public Iterable<Book> displayBooks() {
        try {
            return bookCrud.findAll();
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("show/{id}")
    public Optional<Book> displayBooksById(@PathVariable("id") Long id) {
        try {
            return bookCrud.findById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
