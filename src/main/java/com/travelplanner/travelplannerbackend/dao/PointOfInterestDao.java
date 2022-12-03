package com.travelplanner.travelplannerbackend.dao;

import com.travelplanner.travelplannerbackend.entity.City;
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
    public List<City> getCity() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<City> criteria = builder.createQuery(City.class);
            criteria.from(City.class);
            return session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<PointOfInterest> getAllPointOfInterest(int cityId){
        try (Session session = sessionFactory.openSession()) {
            City city=session.get(City.class,cityId);
            if(city!=null){
                return city.getPointOfInterest();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public PointOfInterest getPointOfInterest(int PointId){
        try (Session session = sessionFactory.openSession()) {
            return session.get(PointOfInterest.class,PointId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
