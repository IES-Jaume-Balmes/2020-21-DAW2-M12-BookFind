package com.findbook.demo.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;
    private String category;


    @ManyToMany
    List<Book> listBooks;

    public Category(String category) {
        this.category = category;
    }

    public Category() {

    }
}
