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
    public void savePointOfInterest(int planId, int indexOfSmallerPlan, int pointOfInterestId){

        Authentication loggInUser= SecurityContextHolder.getContext().getAuthentication();
        String userName=loggInUser.getName();
        User user=userService.getUser(userName);
        pointOfInterestDao.savePointOfInterest(indexOfSmallerPlan, pointOfInterestId);

    }
}
