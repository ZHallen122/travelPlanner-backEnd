package com.travelplanner.travelplannerbackend.controller;

import com.travelplanner.travelplannerbackend.entity.City;
import com.travelplanner.travelplannerbackend.entity.PointOfInterest;
import com.travelplanner.travelplannerbackend.service.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PointOfInterestController {
    @Autowired
    private PointOfInterestService pointOfInterestService;

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ResponseBody
    public List<City> getAllPointOfInterest() {
        return pointOfInterestService.getCity();}

    @RequestMapping(value = "/city/{cityId}/Point", method = RequestMethod.GET)
    @ResponseBody
    public List<PointOfInterest> getPointOfInterest(@PathVariable(value = "cityId")int cityId) {
        return pointOfInterestService.getAllPointOfInterest(cityId);}
}
