package com.findbook.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;


@Entity
public class LineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lineItemsId;

    //TODO: Puede tener muchos libros, pero Stock (un libro ID, muchas cantidades)
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;


    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    /*    @JsonIgnore*/
    //Un lineitem no puede ser empty
    @Min(1)
    private Integer quantity;
    private BigDecimal totalPrice;

    public LineItems(Book book, @Min(1) Integer quantity) {
        this.book = book;
        this.quantity = quantity;
        this.totalPrice = book.getPrice().multiply(new BigDecimal(this.getQuantity()));
        //this.totalPrice = book.getPrice();
    }

    public LineItems() {
    }


//TODO: ADD More info about the product, like productStock, categoryType, description etc
    /*  @Min(0)
    // private Integer productStock;*/

    // <editor-fold defaultstate="collapsed" desc=" GETTERS AND SETTERS ">
    public Long getLineItemsId() {
        return lineItemsId;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    // </editor-fold>
}
