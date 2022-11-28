package com.travelplanner.travelplannerbackend.service;

import com.travelplanner.travelplannerbackend.dao.PlanDao;
import com.travelplanner.travelplannerbackend.entity.Cart;
import com.travelplanner.travelplannerbackend.entity.Plan;
import com.travelplanner.travelplannerbackend.entity.SmallerPlan;
import com.travelplanner.travelplannerbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

        Authentication loggInUser= SecurityContextHolder.getContext().getAuthentication();
        String userName=loggInUser.getName();
        User user=userService.getUser(userName);

        plan.setPlan_title(title_Name);
        plan.setTotal_day(totalDate);
        plan.setCart(user.getCart());
        planDao.save(plan);
    }

    public Plan getPlan(int indexOfPlan){

        Authentication loggInUser= SecurityContextHolder.getContext().getAuthentication();
        String userName=loggInUser.getName();
        User user=userService.getUser(userName);

        Cart cart=user.getCart();
        List<Plan>temp=cart.getPlanOfList();
        return temp.get(indexOfPlan);
    }
}
