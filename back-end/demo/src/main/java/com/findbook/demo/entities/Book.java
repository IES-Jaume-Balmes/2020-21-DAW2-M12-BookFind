package com.findbook.demo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String sn;
    private String image; //aqui va la url de la imagen
    private String name;
    private int year;
    private String author;
    private String desc;
    private float price;

    public Book() {
    }

    public Book(String sn, String image, String name, int year, String author, String desc, float price) {
        super();
        this.sn = sn;
        this.image = image;
        this.name = name;
        this.year = year;
        this.author = author;
        this.desc = desc;
        this.price = price;
    }
}