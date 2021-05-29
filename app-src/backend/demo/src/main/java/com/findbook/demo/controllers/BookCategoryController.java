package com.findbook.demo.controllers;

import com.findbook.demo.entities.Book;
import com.findbook.demo.entities.Category;
import com.findbook.demo.services.BooksService;
import com.findbook.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookCategoryController {
    @Autowired
    BooksService booksService;
    @Autowired
    CategoryService categoryService;


    //books/page?pageSize=0&pageNumber=12&sort=id,desc
    //All categories
    @GetMapping("/category")
    public Page<Category> showCategory(Pageable pageable) {
        return categoryService.getCategoryPage(pageable);
    }

    /**
     * @param /{type} Nombre de la categoria
     * @return list of objects
     */

    @GetMapping("/category/{type}")
    public List<Book> showOne(@PathVariable("type") String categoryType, Pageable pageable) {

        Category category = categoryService.findByCategory(categoryType);
        List<Book> booksByCategory = booksService.findByCategories(category);

        return booksByCategory;
    }
    //TODO: Get by one, none pagination

}
