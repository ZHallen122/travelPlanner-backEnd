package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Place {
    @Id
    private String place;
}
