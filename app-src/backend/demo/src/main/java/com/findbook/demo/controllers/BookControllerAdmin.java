package com.findbook.demo.controllers;

import com.findbook.demo.entities.Book;

import com.findbook.demo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/admin/books")
public class BookControllerAdmin {
    @Autowired
    private BooksService booksService;

    //TODO: Crear libro
    //TODO: Añadir seguridad, solo admin puede crear libros
    @PostMapping("/new")
    public ResponseEntity create(@RequestBody Book product) {

        return booksService.createBook(product);
    }

    //TODO: Modificar libro UPDATE
    @PutMapping("/update")
    public Book updateProduct(@RequestBody Book product) {
        return booksService.updateBook(product);
    }

    //TODO: DELATE BOOK
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        return booksService.deleteBook(id);
    }

    //TODO: controlador filtrar por categoria (género del libro)


    //TODO: Filtrar por autor

}
