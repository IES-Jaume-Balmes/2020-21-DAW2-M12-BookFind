package com.findbook.demo.dao;

import com.findbook.demo.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    Optional<Category> findById(Long aLong);

    Category findOneByCategory(String name);

  //  List<Category> findByListBooksAndCategory(String category);
}