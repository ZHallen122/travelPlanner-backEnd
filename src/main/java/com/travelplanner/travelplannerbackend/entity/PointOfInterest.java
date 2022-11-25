package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Point_Of_Interest")
public class PointOfInterest {

    @Id
    // things inside table
    private String point_name;
    private String description;
    private String longitude;
    private String latitude;

    //To make more advance we need to store pictrue url
    private String picture_URL;

    //wait for add relation

    //Apis get and set
    public String getPoint_name(){return this.point_name;}
    public void setPoint_name(String point_name){this.point_name=point_name;}

    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description=description;}

    public String getLongitude(){return this.longitude;}
    public void setLongitude(String longitude){this.longitude=longitude;}

    public String getLatitude(){return this.latitude;}
    public void setLatitude(String latitude){this.latitude=latitude;}

    public String getPicture_URL(){return this.picture_URL;}
    public void setPicture_URL(String picture_URL){this.picture_URL=picture_URL;}
}
