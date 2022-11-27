package com.travelplanner.travelplannerbackend.service;

import com.travelplanner.travelplannerbackend.dao.PlanDao;
import com.travelplanner.travelplannerbackend.entity.Cart;
import com.travelplanner.travelplannerbackend.entity.Plan;
import com.travelplanner.travelplannerbackend.entity.PointOfInterest;
import com.travelplanner.travelplannerbackend.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashSet;
import java.util.Set;

public class PlanService {
    @Autowired
    private PointOfInterest pointOfInterest;
    @Autowired
    private UserService userService;

    @Autowired
    private PlanDao planDao;

    public void savePlan(PointOfInterest pointOfInterest){
        //when user add one pointOfInterest, what should the website do?
        // 1. user authentication
        // 2. save pointOfInterest into plan
        // 3. plan is created(is it the first point?)
        //     yes, add to the plan
        //     no, create a new plan and add point to the plan(not implemented yet, recently only one plan is allowed in one cart
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String userName = loggedInUser.getName();
        User user = userService.getUser(userName);
        //check if the plan has already exist
        Cart cart = user.getCart();
        if (cart != null && cart.getPlan() != null){
            cart.getPlan().getPointOfInterestList().add(pointOfInterest);//add pointOfInterest into the list
            planDao.save(pointOfInterest);
        } else {
            final Plan plan = new Plan();

        }
    }
    public Set<PointOfInterest> getPlanList(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String userName = loggedInUser.getName();
        User user = userService.getUser(userName);
        if (user != null) {
            Cart cart = user.getCart();

            return cart.getPlan().getPointOfInterestList();
        }
        return null;
    }
}
