package com.travelplanner.travelplannerbackend.service;

import com.travelplanner.travelplannerbackend.dao.PointOfInterestDao;
import com.travelplanner.travelplannerbackend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PointOfInterestService {
    @Autowired
    private PointOfInterestDao pointOfInterestDao;

    @Autowired
    UserService userService;

    public List<City> getCity(){return pointOfInterestDao.getCity();}
    public List<PointOfInterest> getAllPointOfInterest(int cityId) {
        return pointOfInterestDao.getAllPointOfInterest(cityId);
    }

    public PointOfInterest getPointOfInterest(int id){return pointOfInterestDao.getPointOfInterest(id);}
}
