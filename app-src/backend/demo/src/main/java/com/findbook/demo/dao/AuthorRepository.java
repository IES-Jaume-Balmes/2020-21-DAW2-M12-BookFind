package com.findbook.demo.dao;


import com.findbook.demo.entities.Author;
import com.findbook.demo.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    Optional<Author> findByAuthorId(Long authorId);

    List<Author> findByFullName(String name);
    //Author findOneByFullNameL
}
