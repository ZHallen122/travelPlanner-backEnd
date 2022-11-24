package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //private List<Plan> planOfList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
