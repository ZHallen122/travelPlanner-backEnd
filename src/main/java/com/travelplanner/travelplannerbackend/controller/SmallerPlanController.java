package com.travelplanner.travelplannerbackend.controller;

import com.travelplanner.travelplannerbackend.entity.SmallerPlan;
import com.travelplanner.travelplannerbackend.service.SmallerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SmallerPlanController {
    @Autowired
    private SmallerPlanService smallerPlanService;

    @RequestMapping(value="/dailyPlan",method = RequestMethod.GET)
    @ResponseBody
    public SmallerPlan getSmallerPlan(int indexOfPlan, int indexOfSmallerPlan){
        return smallerPlanService.getSmallerPlan(indexOfPlan,indexOfSmallerPlan);
    }

    @RequestMapping(value="/addDailyPlan", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addSmallerPLan(String name,int day, int tavelMode, int indexOfPlan){
        smallerPlanService.saveSmallerPlan(name,day,tavelMode,indexOfPlan);
    }
}
