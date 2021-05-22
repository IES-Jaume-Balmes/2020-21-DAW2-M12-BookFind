package com.findbook.demo.dao;

import com.findbook.demo.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long aLong);
/*
    Page<Book> findAllByProductStatusOrderByProductIdAsc(Integer productStatus, Pageable pageable);

    Page<Book> findAllByOrderByProductId(Pageable pageable);*/
/*
    Page<Book> findAllByOrderByBookId(Pageable pageable);*/
}
