package com.findbook.demo.controllers;

import com.findbook.demo.entities.Book;

import com.findbook.demo.entities.User;
import com.findbook.demo.services.BooksService;
import com.findbook.demo.services.ImageService;
import com.findbook.demo.services.UserService;
import com.findbook.demo.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.security.Principal;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    private BooksService booksService;
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;

    @PostMapping("/books/new")
    public ResponseEntity<Book> create(@RequestBody Book product) {
        return booksService.createBook(product);
    }

    @PutMapping("/books/update")
    public Book updateProduct(@RequestBody Book product) {
        return booksService.updateBook(product);
    }


    @DeleteMapping("/books/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return booksService.deleteBook(id);
    }


    @PostMapping("/books/save/img")
    public HttpStatus saveBookWithImage(@RequestParam("image") MultipartFile multipartFile, Book product) {
        try {
            imageService.uploadImage(multipartFile);
            if (product != null)
                create(product);
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;
    }

    //Admin user methods, update, delete and create (assign roles)
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<User> deleteAcount(@PathVariable("email") String email) {
        User delete = userService.findOne(email);
        if (delete != null) {
            userService.deleteUser(delete);
            if (userService.findOne(email) == null)
                return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    //Modify an user (must be admin)
    @PutMapping("/user/update-user")
    public ResponseEntity<User> update(@RequestBody User user) {
        try {
            if (userService.findOne(user.getEmail()) == null)
                throw new UsernameNotFoundException("The email does not exists");
            return ResponseEntity.ok(userService.update(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
