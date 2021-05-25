package com.findbook.demo.dao;

import com.findbook.demo.entities.Book;

import com.findbook.demo.entities.Category;
import com.findbook.demo.entities.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long aLong);

    Optional<Book> findByIsbn(String isnb);

    Book findOne(Long bookId);
    //findBooksByBookPublishersPublisherId(Long publisherId)

    /*    Optional<Book> findBooksByCategories(Long categories);*/
    //Optional<Book> findAllByCategories();

    List<Book> findByCategories(Category category);


}
