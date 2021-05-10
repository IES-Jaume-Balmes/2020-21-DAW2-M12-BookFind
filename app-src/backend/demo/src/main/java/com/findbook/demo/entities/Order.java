package com.findbook.demo.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long oderId;
    private Date ordered;
    private Date shipped;
    private String shipTo;
    private float total;
    private String status;

    /**
     *
     */
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public Order(Date ordered, Date shipped, String shipTo, float total) {
        this.ordered = ordered;
        this.shipped = shipped;
        this.shipTo = shipTo;
        this.total = total;
    }

    public Order() {

    }
}
