package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Plam")
public class Plan {
    @Id
    private String planId;
    private String plan_title;
    private int total_day;

}
