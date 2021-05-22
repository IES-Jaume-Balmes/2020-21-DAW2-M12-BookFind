package com.findbook.demo.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Cart {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
/*    private Date created;*/
    private float ivaAmount;
    private float totalMoney;

    /*The items inside the cart, lineItems*/
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LineItems> lineItems;

    @OneToOne
    @JoinColumn(name="userId")
    private User user;

    public Cart(Date created, float ivaAmount, float totalMoney) {
        this.ivaAmount = ivaAmount;
        this.totalMoney = totalMoney;
    }

    public Cart() {

    }
// <editor-fold defaultstate="collapsed" desc=" GETTERS & SETTERS ">

/*    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }*/

    public float getIvaAmount() {
        return ivaAmount;
    }

    public void setIvaAmount(float ivaAmount) {
        this.ivaAmount = ivaAmount;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public List<LineItems> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItems> lineItems) {
        this.lineItems = lineItems;
    }
// </editor-fold>
}
