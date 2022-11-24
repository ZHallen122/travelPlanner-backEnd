package com.travelplanner.travelplannerbackend.service;

import com.travelplanner.travelplannerbackend.dao.UserDao;
import com.travelplanner.travelplannerbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;
    @Autowired
    public UserService(UserDao userDao){
        this.userDao=userDao;
    }
    public void signUp(User user){
        userDao.signUp(user);
    }

    public User getUser(String email){
       return userDao.getUser(email);
    }
}
