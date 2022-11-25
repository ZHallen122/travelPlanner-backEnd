package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SmallerPlan")
public class SmallerPlan {
    @Id
    private int splanId;
    private String smallerPlanName;
    private int day;
    //I think we can represent mode by int like 1=walking
    private int travelMode;

}
