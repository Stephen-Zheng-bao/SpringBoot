package com.example.demo.Basket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/getBasket")
    public String getBasket() {
		int userID = userService.getIDOfCurrentUser();
		System.out.println(basketService.getBasket(userID).get(0).getProduct());
        return "Admin/admin";
    }
    @PostMapping("/addToBasket")
        public String addToBasket(@RequestParam String productID, @RequestParam String quantity, @RequestParam String price ){
        Basket itemAdd = new Basket();
        itemAdd.setProductID(Integer.valueOf(productID));
        itemAdd.setQuantity(Integer.valueOf(quantity));
        itemAdd.setUserID(userService.getIDOfCurrentUser());
        itemAdd.setPrice(price);
        basketService.createBasket(itemAdd);
        return ("redirect:/");
    }

}
