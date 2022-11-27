package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
    @Id

    // things in table
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Cart cart;
    // remember to add relation

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    //Apis get and set
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
