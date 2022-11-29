package com.travelplanner.travelplannerbackend.service;

import com.travelplanner.travelplannerbackend.dao.SmallerPlanDao;
import com.travelplanner.travelplannerbackend.entity.SmallerPlan;
import com.travelplanner.travelplannerbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SmallerPlanService {
    @Autowired
    private UserService userService;

    @Autowired
    private SmallerPlanDao smallerPlanDao;

    public void saveSmallerPlan(String name,int day, int tavelMode, int indexOfPlan){
        SmallerPlan smallerPlan=new SmallerPlan();
        //just for now
        tavelMode=1;

        Authentication loggInUser= SecurityContextHolder.getContext().getAuthentication();
        String userName=loggInUser.getName();
        User user=userService.getUser(userName);

        smallerPlan.setSmallerPlanName(name);
        smallerPlan.setDay(day);
        smallerPlan.setTravelMode(tavelMode);
        smallerPlan.setPlan(user.getCart().getPlanOfList().get(indexOfPlan));
        smallerPlanDao.saveSmallerPlan(smallerPlan);
    }

    public SmallerPlan getSmallerPlan(int indexOfPlan, int indexOfSmallerPlan){
        Authentication loggInUser= SecurityContextHolder.getContext().getAuthentication();
        String userName=loggInUser.getName();
        User user=userService.getUser(userName);

        return user.getCart().getPlanOfList().get(indexOfPlan).getListOfSmallerPlan().get(indexOfSmallerPlan);
    }

}
