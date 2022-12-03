package com.travelplanner.travelplannerbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="point_item")
public class PointItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pointItem_id;

    @ManyToOne
    private PointOfInterest pointOfInterest;

    public PointOfInterest getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(PointOfInterest pointOfInterest) {
        this.pointOfInterest = pointOfInterest;
    }

    @ManyToOne
    @JsonIgnore
    private SmallerPlan smallerPlan;

    public SmallerPlan getSmallerPlan() {
        return smallerPlan;
    }

    public void setSmallerPlan(SmallerPlan smallerPlan) {
        this.smallerPlan = smallerPlan;
    }

    public Integer getPointItem_id() {
        return pointItem_id;
    }

    public void setPointItem_id(Integer pointItem_id) {
        this.pointItem_id = pointItem_id;
    }
}
