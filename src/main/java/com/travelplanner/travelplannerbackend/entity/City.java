package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    private String cityName;
}
