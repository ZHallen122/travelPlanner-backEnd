package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="smallerPlan")
public class SmallerPlan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int splanId;
    private String smallerPlanName;
    private int day;
    //I think we can represent mode by int like 1=walking
    private int travelMode;

    @OneToMany(mappedBy ="smallerPlan",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PointItem>pointItemList;

    @ManyToOne
    private Plan plan;

    public int getSplanId() {
        return splanId;
    }

    public void setSplanId(int splanId) {
        this.splanId = splanId;
    }

    public String getSmallerPlanName() {
        return smallerPlanName;
    }

    public void setSmallerPlanName(String smallerPlanName) {
        this.smallerPlanName = smallerPlanName;
    }

    public int getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(int travelMode) {
        this.travelMode = travelMode;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

   public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<PointItem> getPointItemList() {
        return pointItemList;
    }

    public void setPointItemList(List<PointItem> pointItemList) {
        this.pointItemList = pointItemList;
    }
}
