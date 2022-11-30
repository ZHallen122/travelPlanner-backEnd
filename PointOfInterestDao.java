package com.travelplanner.travelplannerbackend.dao;

import com.travelplanner.travelplannerbackend.entity.PointOfInterest;
import com.travelplanner.travelplannerbackend.entity.SmallerPlan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class PointOfInterestDao {
    @Autowired
    private SessionFactory sessionFactory;
    public List<PointOfInterest> getAllPointOfInterest() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<PointOfInterest> criteria = builder.createQuery(Restaurant.class);
            criteria.from(PointOfInterest.class);
            return session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }
    public void savePointOfInterest(int smallerPlanId, int PointOfInterestId) {
        try (Session session = sessionFactory.openSession()) {
            SmallerPlan smallerPlan = session.get(PointOfInterest.class, smallerPlanId);
            if (smallerPlan != null) {
                smallerPlan.savePointOfInterest(PointOfInterestId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
