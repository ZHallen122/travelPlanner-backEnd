package com.travelplanner.travelplannerbackend.controller;

import com.travelplanner.travelplannerbackend.service.PointItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PointItemController {

    @Autowired
    private PointItemService pointItemService;

    @RequestMapping(value = "/addPoint/{planId}/{smallerId}/{pointId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addPointOfInterest(@PathVariable("planId")int planId, @PathVariable("smallerId")int smallerId, @PathVariable("pointId") int pointId){
        pointItemService.savePointItem(pointId,planId,smallerId);
    }
}
