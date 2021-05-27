package com.findbook.demo.controllers;

import com.findbook.demo.entities.Book;

import com.findbook.demo.services.BooksService;
import com.findbook.demo.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BooksService booksService;

    @GetMapping("/{bookId}")
    public Book showOne(@PathVariable("bookId") Long bookId) {

        Book bookInfo = booksService.findOne(bookId);
        //TODO:
        //        // Product is not available
        //        if (productInfo.getProductStatus().equals(ProductStatusEnum.DOWN.getCode())) {
        //            productInfo = null;
        //        }

        return bookInfo;
    }

    //Paginacion, Spring hace la validacion de los datos, no negativos o numeros muy grandes
    @GetMapping("/page")
    public Page<Book> findABookByPage(Pageable page) {
        return booksService.getBooksPage(page);
    }

    @GetMapping("/price-desc")
    public Page<Book> getBookByPriceDesc(@PageableDefault(sort = "price", direction = Sort.Direction.DESC) Pageable page) {
        return booksService.getBooksPage(page);
    }

    @GetMapping("/price-asc")
    public Page<Book> getBookByPriceAsc(@PageableDefault(sort = "price", direction = Sort.Direction.ASC) Pageable page) {
        return booksService.getBooksPage(page);
    }

    @PostMapping("/books-image/save")
    public String saveUser(@RequestParam("image") MultipartFile multipartFile) throws IOException {

/*        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        Book book = booksService.getOne((long) 1);
        book.setImage(fileName);
        Book savedBook = booksService.save(book);

        String uploadDir = "book-images/" + book.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);*/
/*
        //return new RedirectView("/users", true);*/

        try {
            FileUploadUtil.saveImage(multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return "";
    }
}
