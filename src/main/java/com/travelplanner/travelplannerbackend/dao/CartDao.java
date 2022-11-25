package com.travelplanner.travelplannerbackend.dao;


import com.travelplanner.travelplannerbackend.entity.Cart;
import com.travelplanner.travelplannerbackend.entity.Plan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao {

    @Autowired
    private SessionFactory sessionFactory;
    public void removeItem(int itemId){
        Session session = null;
        try{
            session=sessionFactory.openSession();
            Plan plan = session.get(Plan.class,itemId);
            Cart cart = plan.getCart();
            cart.getPlanOfList().remove(itemId);

            session.beginTransaction();
            session.delete(plan);
            session.getTransaction().commit();

        }catch (Exception ex){
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
