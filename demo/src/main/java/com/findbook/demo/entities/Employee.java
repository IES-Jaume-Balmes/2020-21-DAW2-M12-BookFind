package com.findbook.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empleatId;

    private String name;
    private String username;
    private String psw;

    public Employee() {
    }

    public Employee(String name, String username, String psw) {
        super();
        this.name = name;
        this.username = username;
        this.psw = psw;
    }

    public long getEmpleatId() {
        return empleatId;
    }

    public void setEmpleatId(long empleatId) {
        this.empleatId = empleatId;
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

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}