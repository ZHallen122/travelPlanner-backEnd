package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String planTitle;
    private String startDate;
    private String endDate;
    private String travelMode; //recently not used

    @ManyToMany
    private Set<PointOfInterest> pointOfInterestList;


    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }



    public Set<PointOfInterest> getPointOfInterestList() {
        return pointOfInterestList;
    }

    public void setPointOfInterestList(Set<PointOfInterest> pointOfInterestList) {
        this.pointOfInterestList = pointOfInterestList;
    }
}
