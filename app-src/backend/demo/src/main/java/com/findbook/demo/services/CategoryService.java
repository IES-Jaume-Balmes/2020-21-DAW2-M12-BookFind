package com.findbook.demo.services;

import com.findbook.demo.dao.CategoryRepository;
import com.findbook.demo.entities.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public Page<Category> getCategoryPage(Pageable page) {
        return categoryRepository.findAll(page);
    }

    public Category findByCategory(String category) {
        return categoryRepository.findOneByCategory(category);
    }

    public Page<Category> findAllByCategory(String category, Pageable pageable) {
        return categoryRepository.findAllByCategory(category, pageable);
    }


}
