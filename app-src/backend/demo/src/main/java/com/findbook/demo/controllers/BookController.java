package com.findbook.demo.controllers;

import com.findbook.demo.entities.Book;

import com.findbook.demo.services.BooksService;
import com.findbook.demo.utils.FileUploadUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

    @GetMapping("/title/{bookName}")
    public List<Book> showByBookName(@PathVariable("bookName") String bookName) {
        return booksService.findByTitle(bookName);
    }

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


}
