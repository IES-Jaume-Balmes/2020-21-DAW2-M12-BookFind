package com.findbook.demo.dao;

import com.findbook.demo.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    public List<Book> findAll();

/*    @Override
    public default Optional<Book> findById(Long id) {

        return this.findById(id);
    }*/

    @Override
    Optional<Book> findById(Long aLong);
}
