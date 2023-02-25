package com.example.demo.Basket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.User.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class BasketController {

private final  BasketService basketService;
private final UserService userService;

    @Autowired
    public BasketController(BasketService basketService, UserService userService){
        this.basketService = basketService;
		this.userService = userService;
    }
    /*
    * Returns an ArrayList of basketItems
    * */
    @GetMapping("/getBasket")
    @ResponseBody
    public ArrayList<basketItem> getBasket() {
		int userID = userService.getIDOfCurrentUser();
		return basketService.getBasket(userID);
    }
    /*
    * Adds an item to the basket
    * */
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
