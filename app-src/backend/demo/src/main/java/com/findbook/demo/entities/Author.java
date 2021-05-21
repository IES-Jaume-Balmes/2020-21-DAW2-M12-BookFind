package com.findbook.demo.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;
    private String firstName;
    private String lastName;
/*    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<Book> books;*/

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    // </editor-fold>
}
