package com.travelplanner.travelplannerbackend.controller;

import com.travelplanner.travelplannerbackend.entity.Plan;
import com.travelplanner.travelplannerbackend.entity.PointOfInterest;
import com.travelplanner.travelplannerbackend.service.PlanService;
import com.travelplanner.travelplannerbackend.service.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;


@Controller
public class PlanController {
    @Autowired
    private PlanService planService;
    @RequestMapping(value = "/plan", method = RequestMethod.GET)
    @ResponseStatus
    public Set<PointOfInterest> getPlan(){return planService.getPlanList();}

    @RequestMapping(value = "/plan/{point_name}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addPointOfInterestToPlan(@PathVariable("point_name") PointOfInterest pointOfInterest) {
        planService.savePlan(pointOfInterest);
    }
}
