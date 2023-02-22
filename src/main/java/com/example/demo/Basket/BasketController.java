package com.example.demo.Basket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.User.UserService;

@Controller
public class BasketController {

private final  BasketService basketService;
private final UserService userService;
    @Autowired
    public BasketController(BasketService basketService, UserService userService){
        this.basketService = basketService;
		this.userService = userService;
    }

    public String addToBasket(@RequestParam String productID) {
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = user.getPrincipal().toString();
		int userID = userService.findByEmail(userEmail);
		basketService.getBasket(userID);
		
    	return "index";
		
    	
    }
}
