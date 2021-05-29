package com.findbook.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    private Long Bookid;
    @Column(unique = true)
    private String isbn;
    private String image;
    private String title;
    private Date publishedDate;
    @Lob
    @Column(length = 100000)
    private String description;
    private BigDecimal price;
    //New features
    @NotNull
    @Min(0)
    private Integer productStock;
    private Integer numOfPages;
    /**
     * 0: on-sale 1: off-sale
     */
    @ColumnDefault("0")
    private Integer productStatus;
    @JsonIgnore
    @OneToMany(mappedBy = "book", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<LineItems> cartItems;

    @ManyToMany
    List<Category> categories;

    /*    @ManyToOne
        private Author autor;*/
    private String author;

    public Book() {

    }

    public Book(String isbn, String author, String image, String name, Date year, String desc, BigDecimal price, Integer numOfPages) {
        super();
        this.isbn = isbn;
        this.author = author;
        this.image = image;
        this.title = name;
        this.publishedDate = year;
        this.description = desc;
        this.price = price;
        this.numOfPages = numOfPages;
    }

// <editor-fold defaultstate="collapsed" desc=" GETTERS AND SETTERS ">


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String autor) {
        this.author = autor;
    }

    public Long getBookid() {
        return Bookid;
    }

    public void setBookid(Long bookId) {
        this.Bookid = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date year) {
        this.publishedDate = year;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<LineItems> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<LineItems> cartItems) {
        this.cartItems = cartItems;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Integer getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(Integer numOfPages) {
        this.numOfPages = numOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + Bookid +
                ", isbn='" + isbn + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", publishedDate=" + publishedDate +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", cartItems=" + cartItems +
                ", categories=" + categories +
                '}';
    }
    // </editor-fold>
}