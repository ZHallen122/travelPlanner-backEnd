package com.travelplanner.travelplannerbackend.controller;

import com.travelplanner.travelplannerbackend.entity.SmallerPlan;
import com.travelplanner.travelplannerbackend.service.SmallerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SmallerPlanController {
    @Autowired
    private SmallerPlanService smallerPlanService;

    @RequestMapping(value="/dailyPlan",method = RequestMethod.GET)
    @ResponseBody
    public SmallerPlan getSmallerPlan(@RequestParam("plan")int indexOfPlan, @RequestParam("dailyPlan")int indexOfSmallerPlan){
        return smallerPlanService.getSmallerPlan(indexOfPlan,indexOfSmallerPlan);
    }

    @RequestMapping(value="/addDailyPlan", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addSmallerPLan(@RequestParam("name")String name, @RequestParam("day") int day, @RequestParam("tavelMode") int tavelMode, @RequestParam("indexOfPlan") int indexOfPlan){
        smallerPlanService.saveSmallerPlan(name,day,tavelMode,indexOfPlan);
    }
}
