package com.travelplanner.travelplannerbackend.controller;

import com.travelplanner.travelplannerbackend.entity.PointOfInterest;
import com.travelplanner.travelplannerbackend.service.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PointOfInterestController {
    @Autowired
    private PointOfInterestService pointOfInterestService;

    @RequestMapping(value = "/getAll_pointOfInterest", method = RequestMethod.GET)
    @ResponseBody
    public List<PointOfInterest> getAllPointOfInterest() {
        return pointOfInterestService.getAllPointOfInterest();
    }

    @RequestMapping(value = "/{planId}/{smallerPlanId}/addPointOfInterest/{pointOfInterestID}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void savePointOfInterest(@PathVariable int planId,@PathVariable int smallerPlanId,@PathVariable int pointOfInterestID) {
        pointOfInterestService.savePointOfInterest( planId,smallerPlanId,pointOfInterestID);
    }
}
