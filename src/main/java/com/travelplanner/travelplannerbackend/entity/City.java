package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="city")
public class City implements Serializable {
    @Id
    private int id;
    private String cityName;
    private String description;
    private long longitude;
    private long latitude;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PointOfInterest>pointOfInterestList;
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

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public List<PointOfInterest> getPointOfInterest() {
        return pointOfInterestList;
    }

    public void setPointOfInterest(List<PointOfInterest> pointOfInterestList) {
        this.pointOfInterestList = pointOfInterestList;
    }
}
