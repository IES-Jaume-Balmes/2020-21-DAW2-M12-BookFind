package com.findbook.demo.dao;

import com.findbook.demo.entities.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    Optional<Category> findById(Long aLong);

    Category findOneByCategory(String name);


    Page<Category> findAllByCategory(String category, Pageable pageable);

}