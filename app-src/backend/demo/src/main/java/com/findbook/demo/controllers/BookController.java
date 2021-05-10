package com.findbook.demo.controllers;

import com.findbook.demo.DAO.BookRepository;
import com.findbook.demo.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("bookfind/books")
public class BookController {

    @Autowired
    BookRepository proRep;

    //WIP
    @GetMapping("/new")
    public String displayBookForm(Model model) {
        Book nouBook = new Book();
        model.addAttribute("book", nouBook);
        return " ";


    }
    //agregar libro
    @PostMapping("/save")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        if (book != null) {
            proRep.save(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se puedo agregar el libro.");
        }
    }

    //mostrar todos los libros añadidos
    @GetMapping("/show")
    public Iterable<Book> mostrarBooks() {
        try {
            return proRep.findAll();
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay libros agregados.");
        }
    }

}
