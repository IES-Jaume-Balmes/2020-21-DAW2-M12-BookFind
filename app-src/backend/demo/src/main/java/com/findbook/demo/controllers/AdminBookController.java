package com.findbook.demo.controllers;

import com.findbook.demo.entities.Book;

import com.findbook.demo.services.BooksService;
import com.findbook.demo.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Optional;

@CrossOrigin
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


    @PostMapping("/save/img")
    public ResponseEntity saveBookWithImage(@RequestParam("image") MultipartFile multipartFile, Book product) {
        try {
            FileUploadUtil.saveImage(multipartFile);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        create(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    //TODO: controlador filtrar por categoria (género del libro)
    //TODO: Filtrar por autor
    //TODO: TESTEAR

}
