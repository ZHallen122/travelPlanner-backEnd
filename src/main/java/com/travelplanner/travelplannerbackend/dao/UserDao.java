package com.travelplanner.travelplannerbackend.dao;

import com.travelplanner.travelplannerbackend.entity.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void signUp(User user){

    }

    public User getUser(String email){
        return new User();
    }
}
