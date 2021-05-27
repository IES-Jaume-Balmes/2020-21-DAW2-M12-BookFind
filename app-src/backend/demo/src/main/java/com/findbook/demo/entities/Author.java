package com.findbook.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;
    private String firstName;
    private String lastName;


    @OneToMany
    @JoinColumn(name = "authorId")
    private List<Book> books;


    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/*    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }*/
    // </editor-fold>
}