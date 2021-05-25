package com.findbook.demo.controllers;

import com.findbook.demo.entities.Book;

import com.findbook.demo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/admin/books")
public class AdminBookController {
    @Autowired
    private BooksService booksService;

    @PostMapping("/new")
    public ResponseEntity create(@RequestBody Book product) {

        return booksService.createBook(product);
    }

    @PutMapping("/update")
    public Book updateProduct(@RequestBody Book product) {
        return booksService.updateBook(product);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        return booksService.deleteBook(id);
    }

    //TODO: controlador filtrar por categoria (género del libro)
    //TODO: Filtrar por autor

 
}
