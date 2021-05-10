package com.findbook.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sn")
    private String sn;

    @Column(name = "name")
    //@NotBlank(message = "Please Enter the Product Name")
    private String name;

    @Column(name = "description")
    @JsonIgnore
    //@NotBlank(message = "Please Enter the Product Description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "unit_price")
    //@Min(value = 1, message = "Unit Price atleast one (1)")
    private double unitPrice;

    @Column(name = "quantity")
    private int quantity;


    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", sn='" + sn +
                ", name='" + name +
                ", description='" + description +
                ", imageUrl='" + imageUrl +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }
}