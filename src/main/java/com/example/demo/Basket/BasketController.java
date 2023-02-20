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

}
