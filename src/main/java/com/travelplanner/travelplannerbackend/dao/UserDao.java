package com.travelplanner.travelplannerbackend.dao;

import com.travelplanner.travelplannerbackend.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;
    public void signUp(User user){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            if(session != null){
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    public User getUser(String email){
        User user = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            user = session.get(User.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return user;
    }
}
