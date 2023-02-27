package com.example.demo.Basket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.User.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/basket")

    public String getBasket(Model model) {
		int userID = userService.getIDOfCurrentUser();
		List<basketItem> basket = basketService.getBasket(userID);
        model.addAttribute("baskets",basket);
        return "Basket/basket";
    }
    /*
    * Adds an item to the basket
    * */
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/addToBasket")
        public String addToBasket(@RequestParam String productID, @RequestParam String quantity, @RequestParam String price ){
        Basket itemAdd = new Basket();
        itemAdd.setProductID(Integer.valueOf(productID));
        /*itemAdd.setQuantity(Integer.valueOf(quantity));*/
        itemAdd.setQuantity(1);
        itemAdd.setUserID(userService.getIDOfCurrentUser());
        itemAdd.setPrice(price);
        basketService.createBasket(itemAdd);
        return ("redirect:/");
    }

}
