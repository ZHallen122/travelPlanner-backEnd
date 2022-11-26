package com.travelplanner.travelplannerbackend.service;

import com.travelplanner.travelplannerbackend.dao.PlanDao;
import com.travelplanner.travelplannerbackend.entity.Plan;
import com.travelplanner.travelplannerbackend.entity.SmallerPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {

    //@Autowired

    @Autowired
    UserService userService;

    @Autowired
    PlanDao planDao;

    public void savePlan(String title_Name,int totalDate){
        Plan plan=new Plan();

        //Authentication wait

        plan.setPlan_title(title_Name);
        plan.setTotal_day(totalDate);
       // plan.setCart();
        planDao.save(plan);
    }

   // public Plan getPlan(){

   // }
}
