package com.travelplanner.travelplannerbackend.service;

import com.travelplanner.travelplannerbackend.dao.PointItemDao;
import com.travelplanner.travelplannerbackend.entity.PointItem;
import com.travelplanner.travelplannerbackend.entity.PointOfInterest;
import com.travelplanner.travelplannerbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PointItemService {
    @Autowired
    private UserService userService;
    @Autowired
    private PointOfInterestService pointOfInterestService;

    @Autowired
    private PointItemDao pointItemDao;

    public void savePointItem(int pointId,int planId,int smallerPlanId){
        final PointItem pointItem=new PointItem();
        final PointOfInterest pointOfInterest=pointOfInterestService.getPointOfInterest(pointId);

        Authentication loggInUser= SecurityContextHolder.getContext().getAuthentication();
        String userName=loggInUser.getName();
        User user=userService.getUser(userName);

        pointItem.setPointOfInterest(pointOfInterest);
        pointItem.setSmallerPlan(user.getCart().getPlanOfList().get(planId).getListOfSmallerPlan().get(smallerPlanId));
        pointItemDao.savePointItem(pointItem);
    }


}
