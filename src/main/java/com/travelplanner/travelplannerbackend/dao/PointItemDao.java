package com.travelplanner.travelplannerbackend.dao;

import com.travelplanner.travelplannerbackend.entity.PointItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointItemDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void savePointItem(PointItem pointItem) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(pointItem);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            //if anything goes wrong we rollback.
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
