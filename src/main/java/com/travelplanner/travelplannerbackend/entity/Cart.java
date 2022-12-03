package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy ="cart",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Plan> planOfList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Plan> getPlanOfList() {
        return planOfList;
    }

    public void setPlanOfList(List<Plan> planOfList) {
        this.planOfList = planOfList;
    }
}
