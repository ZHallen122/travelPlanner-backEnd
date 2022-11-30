package com.travelplanner.travelplannerbackend.service;

import com.travelplanner.travelplannerbackend.dao.PointOfInterestDao;
import com.travelplanner.travelplannerbackend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public class PointOfInterestService {
    @Autowired
    private PointOfInterestDao pointOfInterestDao;

    @Autowired
    UserService userService;

    public List<PointOfInterest> getAllPointOfInterest() {
        return pointOfInterestDao.getAllPointOfInterest();
    }
    public void savePointOfInterest(int indexOfPlan, int indexOfSmallerPlan, int pointOfInterestId){

        Authentication loggInUser= SecurityContextHolder.getContext().getAuthentication();
        String userName=loggInUser.getName();
        User user=userService.getUser(userName);
        Cart cart = user.getCart();
        Plan plan = cart.getPlanOfList().get(indexOfPlan);
        SmallerPlan smallerPlan = plan.getSmallerPlan.get(indexOfSmallerPlan);
        smallerPlan.getPointOfInterestList().add(pointOfInterestId);

    }
}
