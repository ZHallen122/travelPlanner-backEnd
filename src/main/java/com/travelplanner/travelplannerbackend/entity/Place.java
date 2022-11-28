package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="place")
public class Place {

  //!!!!!!!!!!!!!!! Not sure yet dont do this table.
    @Id
    private String place;

    @ManyToOne
    private PointOfInterest pointOfInterest;

    public PointOfInterest getPointOfInterest() {
      return pointOfInterest;
    }

    public void setPointOfInterest(PointOfInterest pointOfInterest) {
      this.pointOfInterest = pointOfInterest;
    }

    @ManyToOne
    private Plan plan;

    public Plan getPlan() {
      return plan;
    }

    public void setPlan(Plan plan) {
      this.plan = plan;
    }

  public String getPlace() {
      return place;
    }

    public void setPlace(String place) {
      this.place = place;
    }
}
