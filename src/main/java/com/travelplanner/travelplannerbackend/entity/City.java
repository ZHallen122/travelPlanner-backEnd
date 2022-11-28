package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="city")
public class City {
    @Id
    private int id;
    private String cityName;
    private String description;
    private String address;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PointOfInterest>pointOfInterest;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
