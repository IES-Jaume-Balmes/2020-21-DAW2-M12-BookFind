package com.findbook.demo.controllers;

import com.findbook.demo.entities.Author;
import com.findbook.demo.entities.Book;

import com.findbook.demo.entities.Category;
import com.findbook.demo.services.AuthorService;
import com.findbook.demo.services.BooksService;
import com.findbook.demo.services.CategoryService;
import com.findbook.demo.services.ImageService;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private ImageService imageService;

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> showOne(@PathVariable("bookId") Long bookId) {
        Book bookInfo = booksService.findOne(bookId);
        if (bookInfo == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bookInfo, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Book> showAll() {
        return booksService.findAll();
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

    @GetMapping("/author/{author}")
    public List<Book> showByBookAuthor(@PathVariable("author") String bookName, Pageable pageable) {
        return booksService.findByTitle(bookName);
    }

    /**
     * @param categoryType String for example 'Classics'
     * @param pageable     Classics?pageSize=5&pageNumber=0
     * @return Page<Books> list of books by category
     */
    @GetMapping("/category/{type}")
    public Page<Book> showByCategory(@PathVariable("type") String categoryType, Pageable pageable) {
        Category find = categoryService.findByCategory(categoryType);
        return booksService.findAllByCategories(find, pageable);
    }

    /**
     * @param categoryType the id of the category
     * @param pageable     /category/id/1?pageSize=5&pageNumber=0
     * @return Page<Books> list of books by category
     */
    @GetMapping("/category/id/{number}")
    public Page<Book> showByCategoryId(@PathVariable("number") Long categoryType, Pageable pageable) {
        Category find = categoryService.findOneByCategoryId(categoryType);
        return booksService.findAllByCategories(find, pageable);
    }

    //AUTHOR
    @GetMapping("/author/{name}")
    public Page<Book> showByAuthor(@PathVariable("name") String fullName, Pageable pageable) {
        Author author = authorService.findByAuthorName(fullName);
        return booksService.getAllBooksByAuthor(author, pageable);
    }

    /**
     * @param authorId id of author to find
     * @param pageable /books/author/id/1?pageSize=5&pageNumber=0
     * @return Page<Books> list of books by category
     */
    @GetMapping("/author/id/{number}")
    public Page<Book> showByAuthorId(@PathVariable("number") Long authorId, Pageable pageable) {
        Author author = authorService.findOneByCategoryId(authorId);
        return booksService.getAllBooksByAuthor(author, pageable);
    }


    /*Get image by name*/
    @SneakyThrows
    @GetMapping(value = "/images/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) {
        byte[] image = imageService.getImageWithMediaType(name);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}
