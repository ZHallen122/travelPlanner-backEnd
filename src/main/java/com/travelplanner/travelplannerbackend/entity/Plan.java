package com.travelplanner.travelplannerbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="Plam")
public class Plan {
    @Id
    private String planId;
    private String plan_title;
    private int total_day;

    @ManyToOne
    private SmallerPlan smallerPlan;

    @ManyToOne
    @JsonIgnore
    private Cart cart;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlan_title() {
        return plan_title;
    }

    public void setPlan_title(String plan_title) {
        this.plan_title = plan_title;
    }

    public int getTotal_day() {
        return total_day;
    }

    public void setTotal_day(int total_day) {
        this.total_day = total_day;
    }

    public SmallerPlan getSmallerPlan() {
        return smallerPlan;
    }

    public void setSmallerPlan(SmallerPlan smallerPlan) {
        this.smallerPlan = smallerPlan;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
