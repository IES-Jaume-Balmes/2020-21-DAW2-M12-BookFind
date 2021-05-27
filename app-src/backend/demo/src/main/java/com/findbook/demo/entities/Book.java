package com.findbook.demo.entities;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @Column(unique = true)
    private Long bookId;
    @Column(unique = true)
    private String isbn;
    private String image;
    private String title;
    private Date publishedDate;
    private String description;
    private BigDecimal price;
    //New features
    @NotNull
    @Min(0)
    private Integer productStock;

    /**
     * 0: on-sale 1: off-sale
     */
    @ColumnDefault("0")
    private Integer productStatus;
    /*  @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)*/
    @OneToMany(mappedBy = "book", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<LineItems> cartItems;

    @ManyToMany
    List<Category> categories;

/*    @ManyToOne
    Author autor;*/

    public Book() {

    }

    public Book(String isbn, String image, String name, Date year, String desc, BigDecimal price) {
        super();
        this.isbn = isbn;
        this.image = image;
        this.title = name;
        this.publishedDate = year;
        this.description = desc;
        this.price = price;
    }

    // <editor-fold defaultstate="collapsed" desc=" GETTERS AND SETTERS ">
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
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