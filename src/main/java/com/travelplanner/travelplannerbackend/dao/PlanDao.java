package com.travelplanner.travelplannerbackend.dao;

import com.travelplanner.travelplannerbackend.entity.Plan;
import com.travelplanner.travelplannerbackend.entity.PointOfInterest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PlanDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(PointOfInterest point) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(point);
            session.getTransaction().commit();//finally commit(结束即成功 失败就回滚)

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
