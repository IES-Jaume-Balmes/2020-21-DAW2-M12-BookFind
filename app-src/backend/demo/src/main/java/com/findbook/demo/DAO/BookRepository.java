package com.findbook.demo.DAO;

import com.findbook.demo.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    public List<Book> findAll();
}
