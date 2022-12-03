package com.travelplanner.travelplannerbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="point_Of_Interest")
public class PointOfInterest implements Serializable {

    @Id
    private int pointOfInterestId;
    private String point_name;
    private String description;
    private long longitude;
    private long latitude;

    private String address;

    //To make more advance we need to store picture url
    private String picture_URL;

    public int getId() {
        return pointOfInterestId;
    }

    public void setId(int id) {
        this.pointOfInterestId = id;
    }


    @ManyToOne
    @JsonIgnore
    private City city;

    //Apis get and set
    public String getPoint_name(){return this.point_name;}
    public void setPoint_name(String point_name){this.point_name=point_name;}

    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description=description;}

    public long getLongitude(){return this.longitude;}
    public void setLongitude(long longitude){this.longitude=longitude;}

    public long getLatitude(){return this.latitude;}
    public void setLatitude(long latitude){this.latitude=latitude;}

    public String getPicture_URL(){return this.picture_URL;}
    public void setPicture_URL(String picture_URL){this.picture_URL=picture_URL;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}