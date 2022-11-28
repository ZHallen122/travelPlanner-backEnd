package com.travelplanner.travelplannerbackend.controller;

import com.travelplanner.travelplannerbackend.entity.Plan;
import com.travelplanner.travelplannerbackend.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlanController {

    @Autowired
    private PlanService planService;

    //Not sure
    @RequestMapping(value="/plan", method = RequestMethod.GET)
    @ResponseBody
    public Plan getPlan (int indexOfPlan){
        return planService.getPlan(indexOfPlan);
    }

    @RequestMapping(value="/addplan", method = RequestMethod.POST)
    @ResponseBody
    public void addPlan(String title_Name,int totalDate){
            planService.savePlan(title_Name,totalDate);
    }
}
