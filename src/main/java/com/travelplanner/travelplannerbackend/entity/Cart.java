package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.*;
import java.util.Set;

@Entity

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Plan plan;

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
