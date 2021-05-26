package com.findbook.demo.entities;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


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
    /*  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)*/
    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<LineItems> lineItems;

    @OneToOne
    @JoinColumn(name = "userId")
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

    public Set<LineItems> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItems> lineItems) {
        this.lineItems = lineItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", ivaAmount=" + ivaAmount +
                ", totalMoney=" + totalMoney +
                ", lineItems=" + lineItems +
                ", user=" + user +
                '}';
    }

    // </editor-fold>
}
