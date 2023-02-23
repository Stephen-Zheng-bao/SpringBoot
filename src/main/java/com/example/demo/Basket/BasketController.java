package com.example.demo.Basket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BasketController {

private final  BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService){
        this.basketService = basketService;
    }

    public String addToBasket(@RequestParam String productID) {
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = user.getPrincipal().toString();
		int userID = userService.findByEmail(userEmail);
		basketService.getBasket(userID);
    	return "index";
		
    	
    }
}
