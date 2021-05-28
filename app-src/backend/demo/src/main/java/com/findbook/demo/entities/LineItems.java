package com.findbook.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;


@Entity
public class LineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long lineItemsId;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;
    @Min(1)
    private Integer quantity;
    private BigDecimal totalPrice;

    //TODO: ADD THE REFERENCE TO THE ORDER, ONE OR 0
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oderId")
    @JsonIgnore
    private OrderProducts order;

    public LineItems(Book book, @Min(1) Integer quantity) {
        this.book = book;
        this.quantity = quantity;
        this.totalPrice = book.getPrice().multiply(new BigDecimal(this.getQuantity()));
    }

    public LineItems() {
    }

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

    public void setLineItemsId(Long lineItemsId) {
        this.lineItemsId = lineItemsId;
    }

    public OrderProducts getOrder() {
        return order;
    }

    public void setOrder(OrderProducts order) {
        this.order = order;
    }
// </editor-fold>
}
