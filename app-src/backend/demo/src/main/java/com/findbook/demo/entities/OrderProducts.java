package com.findbook.demo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long oderId;
    private Date ordered;
    private Date shipped;
    private String shipTo;
    private BigDecimal total;
    //TODO: Enum for the status
    private String status;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private Set<LineItems> booksLineItems = new HashSet<>(); //Keyvalue


    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public OrderProducts(Date ordered, Date shipped, String shipTo, BigDecimal total) {
        this.ordered = ordered;
        this.shipped = shipped;
        this.shipTo = shipTo;
        this.total = total;
    }

    public OrderProducts(User user) {
        this.user = user;
        this.total = user.getCart().getTotalMoney();
    }


    public OrderProducts() {

    }
    // <editor-fold defaultstate="collapsed" desc=" GETTERS AND SETTERS ">

    public long getOderId() {
        return oderId;
    }

    public void setOderId(long oderId) {
        this.oderId = oderId;
    }

    public Date getOrdered() {
        return ordered;
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Long getTotalLong() {
        return total.longValue();
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<LineItems> getBooksLineItems() {
        return booksLineItems;
    }

    public void setBooksLineItems(Set<LineItems> booksLineItems) {
        this.booksLineItems = booksLineItems;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderProducts{" +
                "oderId=" + oderId +
                ", ordered=" + ordered +
                ", shipped=" + shipped +
                ", shipTo='" + shipTo + '\'' +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", booksLineItems=" + booksLineItems +
                ", cart=" + cart +
                ", user=" + user +
                '}';
    }

    // </editor-fold>
}
