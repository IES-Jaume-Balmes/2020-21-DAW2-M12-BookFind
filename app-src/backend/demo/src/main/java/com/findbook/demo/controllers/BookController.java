package com.findbook.demo.controllers;

import com.findbook.demo.entities.Book;

import com.findbook.demo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BooksService booksService;

    @GetMapping("/{bookId}")
    public Optional<Book> showOne(@PathVariable("bookId") Long bookId) {

        Optional<Book> bookInfo = booksService.findOne(bookId);
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


}
