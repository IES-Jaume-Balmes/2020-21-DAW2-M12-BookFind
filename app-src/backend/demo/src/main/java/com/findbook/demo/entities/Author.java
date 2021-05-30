package com.findbook.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long authorId;
    @Column(name = "name")
    private String fullName;

/*

    @OneToMany
    private List<Book> books;
*/


    public Author(String firstName, String lastName) {
        this.fullName = firstName;

    }

    public Author() {

    }
    // <editor-fold defaultstate="collapsed" desc=" GETTERS AND SETTERS ">


    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long userId) {
        this.authorId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName) {
        this.fullName = firstName;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
/*
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }*/

    // </editor-fold>
}