package com.travelplanner.travelplannerbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="plan")
public class Plan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int planId;
    private String plan_title;
    private int total_day;

    @OneToMany(mappedBy ="plan",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SmallerPlan> listOfSmallerPlan;

    @ManyToOne
    @JsonIgnore
    private Cart cart;

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
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

    public List<SmallerPlan> getListOfSmallerPlan() {
        return listOfSmallerPlan;
    }

    public void setListOfSmallerPlan(List<SmallerPlan> listOfSmallerPlan) {
        this.listOfSmallerPlan = listOfSmallerPlan;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
   }
}
