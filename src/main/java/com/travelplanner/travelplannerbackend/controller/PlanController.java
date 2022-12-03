package com.travelplanner.travelplannerbackend.controller;

import com.travelplanner.travelplannerbackend.entity.Plan;
import com.travelplanner.travelplannerbackend.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlanController {

    @Autowired
    private PlanService planService;

    //Not sure
    @RequestMapping(value="/plan/{indexOfPlan}", method = RequestMethod.GET)
    @ResponseBody
    public Plan getPlan (@PathVariable("indexOfPlan") int indexOfPlan){
        return planService.getPlan(indexOfPlan);
    }

    @RequestMapping(value="/addplan", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addPlan(@RequestParam("title_Name")String title_Name, @RequestParam("totalDate")int totalDate){
            planService.savePlan(title_Name,totalDate);
    }
}
