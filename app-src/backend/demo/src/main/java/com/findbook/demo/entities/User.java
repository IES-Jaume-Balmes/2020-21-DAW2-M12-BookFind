package com.findbook.demo.entities;

import javax.persistence.*;

@Entity
public class User {
    /**
     * El usuario tiene un carrito, la orden será una instancia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String name;
    private String username;
    private String password;
    private String email;

    private String phone;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    public User() {
    }

    public User(String name, String username, String password, String email, String phone) {
        super();
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;


    }
// <editor-fold defaultstate="collapsed" desc=" GETTERS & SETTERS ">

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String psw) {
        this.password = psw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


// </editor-fold>
}