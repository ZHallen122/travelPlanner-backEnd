package com.travelplanner.travelplannerbackend.dao;

import com.travelplanner.travelplannerbackend.entity.Plan;
import com.travelplanner.travelplannerbackend.entity.PointOfInterest;
import com.travelplanner.travelplannerbackend.entity.SmallerPlan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PointOfInterestDao {
    @Autowired
    private SessionFactory sessionFactory;
    public List<PointOfInterest> getAllPointOfInterest() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<PointOfInterest> criteria = builder.createQuery(PointOfInterest.class);
            criteria.from(PointOfInterest.class);
            return session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }
    public void savePointOfInterest(int smallerPlanId, int pointOfInterestId) {
        try (Session session = sessionFactory.openSession()) {
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public PointOfInterest getPointOfInterest(int pointId){
        try (Session session = sessionFactory.openSession()) {
            PointOfInterest pointOfInterest=session.get(PointOfInterest.class, pointId);
            session.close();
            return pointOfInterest;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
