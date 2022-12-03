package com.travelplanner.travelplannerbackend.dao;

import com.travelplanner.travelplannerbackend.entity.Plan;
import com.travelplanner.travelplannerbackend.entity.SmallerPlan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SmallerPlanDao {
    @Autowired
    SessionFactory sessionFactory;

    public void saveSmallerPlan(SmallerPlan smallerPlan){
            Session session = null;
            try {
                session = sessionFactory.openSession();
                session.beginTransaction();

                //save to db
                session.save(smallerPlan);
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

        public SmallerPlan getSmallerPlan(int SmallerPlanId){
                Session session=null;
                try{
                    session=sessionFactory.openSession();
                    return session.get(SmallerPlan.class,SmallerPlanId);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                }finally{
                   session.close();
            }
                return null;
        }
    }

