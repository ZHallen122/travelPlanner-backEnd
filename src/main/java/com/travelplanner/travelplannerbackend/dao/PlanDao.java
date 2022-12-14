package com.travelplanner.travelplannerbackend.dao;

import com.travelplanner.travelplannerbackend.entity.Cart;
import com.travelplanner.travelplannerbackend.entity.Plan;
import com.travelplanner.travelplannerbackend.entity.SmallerPlan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public class PlanDao {
    @Autowired
    SessionFactory sessionFactory;
    public void save(Plan plan) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            //save to db
            session.save(plan);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        }finally {
            if(session!=null) {
                session.close();
            }
        }
    }

    public void removeSmallerPlan(int sPlanId){
        Session session = null;
        try {
            session=sessionFactory.openSession();
            SmallerPlan splan = session.get(SmallerPlan.class,sPlanId);
            Plan plan = splan.getPlan();
            plan.getListOfSmallerPlan().remove(sPlanId);

            session.beginTransaction();
            session.delete(splan);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        }finally {
            if(session!=null) {
                session.close();
            }
        }
    }
}
