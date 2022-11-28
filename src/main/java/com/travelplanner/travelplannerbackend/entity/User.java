package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable{

    //not sure
    private static final long serialVersionUID = 2652327633296064143L;

    @Id
    // things in table
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enabled;

    // remember to add relation
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique=true)
    private Cart cart;

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

    public Cart getCart(){
       return cart;
    }

    public void setCart(Cart cart){
        this.cart=cart;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
