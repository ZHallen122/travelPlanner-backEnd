package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="point_Of_Interest")
public class PointOfInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // things inside table
    private int id;
    private String point_name;
    private String description;
    private long longitude;
    private long latitude;

    //To make more advance we need to store picture url
    private String picture_URL;

    //wait for add relation
   // @ManyToOne
  //  private SmallerPlan smallerPlan;

    //will be change in future
    @ManyToMany
    private List<SmallerPlan> smallerPlanIdList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SmallerPlan> getSmallerPlanIdList() {
        return smallerPlanIdList;
    }

    public void setSmallerPlanIdList(List<SmallerPlan> smallerPlanIdList) {
        this.smallerPlanIdList = smallerPlanIdList;
    }

    @ManyToOne
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

  //  public SmallerPlan getSmallerPlan() {
   //     return smallerPlan;
  //  }

  //  public void setSmallerPlan(SmallerPlan smallerPlan) {
  //      this.smallerPlan = smallerPlan;
  //  }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

