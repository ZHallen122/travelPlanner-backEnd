package com.travelplanner.travelplannerbackend.service;


import com.travelplanner.travelplannerbackend.dao.CartDao;
import com.travelplanner.travelplannerbackend.entity.Cart;
import com.travelplanner.travelplannerbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private UserService userService;

    @Autowired
    private CartDao cartDao;

    public Cart getCart(){
        Authentication loggInUser= SecurityContextHolder.getContext().getAuthentication();
        String userName=loggInUser.getName();
        User user=userService.getUser(userName);

        if(user !=null){
            Cart cart=user.getCart();
            return cart;
        }else{
            return new Cart();
        }
    }
}
