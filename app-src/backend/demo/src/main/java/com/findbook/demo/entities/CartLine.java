package com.findbook.demo.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_line")
public class CartLine implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne
    private Book book;

    @Column(name="cart_id")
    private int cartId;

    @Column(name="total")
    private double total;

    @Column(name="product_count")
    private int productCount;

    @Column(name="buying_price")
    private double buyingPrice;


    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }


    @Override
    public String toString() {
        return "CartLine{" +
                "id=" + id +
                ", book=" + book +
                ", cartId=" + cartId +
                ", total=" + total +
                ", productCount=" + productCount +
                ", buyingPrice=" + buyingPrice +
                '}';
    }
}
