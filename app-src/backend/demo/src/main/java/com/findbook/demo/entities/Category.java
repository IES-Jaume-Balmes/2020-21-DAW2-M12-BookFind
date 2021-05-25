package com.findbook.demo.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    @Column(unique = true)
    private String category;


    @ManyToMany
    List<Book> listBooks;

    public Category(String category) {
        this.category = category;
    }

    public Category() {

    }

    // <editor-fold defaultstate="collapsed" desc=" GETTERS AND SETTERS ">
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(List<Book> listBooks) {
        this.listBooks = listBooks;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", listBooks=" + listBooks +
                '}';
    }
    // </editor-fold>
}
