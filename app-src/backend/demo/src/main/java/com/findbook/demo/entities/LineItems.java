package com.findbook.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode
@Entity
public class LineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lineItemsId;

    //TODO: Puede tener muchos libros, pero Stock (un libro ID, muchas cantidades)
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;


    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    /*    @JsonIgnore*/

    private int quantity;
    private double totalPrice;


    //TODO: ADD More info about the product, like productStock, categoryType, description etc
    //  @Min(0)
    // private Integer productStock;

    // <editor-fold defaultstate="collapsed" desc=" GETTERS AND SETTERS ">
    public long getLineItemsId() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    // </editor-fold>
}
