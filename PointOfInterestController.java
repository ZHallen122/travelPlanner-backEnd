package com.travelplanner.travelplannerbackend.controller;

import com.travelplanner.travelplannerbackend.entity.PointOfInterest;
import com.travelplanner.travelplannerbackend.service.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class PointOfInterestController {
    @Autowired
    private PointOfInterestService pointOfInterestService;

    @RequestMapping(value = "/dailyPlan/pointOfInterest", method = RequestMethod.GET)
    @ResponseBody
    public List<PointOfInterest> getAllPointOfInterest() {
        return pointOfInterestService.getAllPointOfInterest();
    }
    @RequestMapping(value = "{planId}/{smallerPlanId}/{pointOfInterestID}", method = RequestMethod.POST)
    @ResponseBody
    public void savePointOfInterest(@PathVariable(value = "planId") int indexOfPlan,@PathVariable(value = "smallerPlanId")int indexOfSmallerPlan,@PathVariable(value = "pointOfInterestId")  int pointOfInterestId) {
        pointOfInterestService.savePointOfInterest(pointOfInterestId);
    }
}