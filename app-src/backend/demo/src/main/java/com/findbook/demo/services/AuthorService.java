package com.findbook.demo.services;

import com.findbook.demo.dao.AuthorRepository;
import com.findbook.demo.entities.Author;
import com.findbook.demo.entities.Category;
import com.findbook.demo.exception.CategoryExistsException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    //find by id
    //Find by name
    /*    Optional<Author> findByAuthorId(Long authorId);

    List<Author> findByFullName(String name);*/
    @SneakyThrows
    public Author findOneByCategoryId(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isEmpty())
            throw new CategoryExistsException();
        return author.get();
    }

 /*   public Author findByCategory(String category) {
        return authorRepository.findByFullName(category);
    }
*/
}
