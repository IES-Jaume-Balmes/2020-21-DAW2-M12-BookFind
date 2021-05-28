package com.findbook.demo.entities;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;


@Entity
public class Cart {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long cartId;
    private BigDecimal totalMoney;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<LineItems> lineItems;

    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;

    public Cart(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Cart() {
        this.totalMoney = new BigDecimal(0);
    }

// <editor-fold defaultstate="collapsed" desc=" GETTERS & SETTERS ">

/*    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }*/
/*
    public float getIvaAmount() {
        return ivaAmount;
    }

    public void setIvaAmount(float ivaAmount) {
        this.ivaAmount = ivaAmount;
    }*/

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void addNewProductMoney(BigDecimal prodcutMoney) {
        this.totalMoney = this.totalMoney.add(prodcutMoney);
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
                ", totalMoney=" + totalMoney +
                ", lineItems=" + lineItems +
                ", user=" + user +
                '}';
    }

    // </editor-fold>
}
