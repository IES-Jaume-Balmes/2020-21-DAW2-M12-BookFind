package com.findbook.demo.dao;

import com.findbook.demo.entities.Author;
import com.findbook.demo.entities.Book;

import com.findbook.demo.entities.Category;
import com.findbook.demo.entities.ConfirmationToken;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long aLong);

    Optional<Book> findByIsbn(String isnb);

    List<Book> findByCategories(Category category);


    List<Book> findByTitleContainingIgnoreCase(String title);

    Page<Book> findAllByCategories(Category category, Pageable pageable);

    @Override
    List<Book> findAll();

    Page<Book> findAllByAuthor(Author author, Pageable pageable);

    //bUSCAR POR AUTHORES SIMILARES


}
