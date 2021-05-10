package com.findbook.demo.entities;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    //@NotBlank(message="Please Enter First Name!")
    private String firstName;

    @Column(name = "last_name")
    //@NotBlank(message="Please Enter Last Name!")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "contact_number")
    //@NotBlank(message="Please Enter Contact number!")
    private String contactNumber;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    //@NotBlank(message="Please Enter Password for Login!")
    private String password;

    public User() {
    }

    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName +
                ", lastName='" + lastName +
                ", email='" + email +
                ", contactNumber='" + contactNumber +
                ", role='" + role +
                ", password='" + password +
                '}';
    }
}