package com.example.demo.Orders;


import com.example.demo.Basket.BasketService;
import com.example.demo.Basket.basketItem;
import com.example.demo.User.UserService;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {

    private final OrdersService ordersService;
    private final UserService userService;
    private final BasketService basketService;

    @Autowired
    public OrdersController(OrdersService ordersService, UserService userService, BasketService basketService){
        this.ordersService = ordersService;
        this.userService = userService;
        this.basketService = basketService;
    }
    @PostMapping("/checkout")
    public String checkout(){
        int userID = userService.getIDOfCurrentUser();
        List<basketItem> basket = basketService.getBasket(userID);
        int orderNum = ordersService.getNewID();
        System.out.println(orderNum);
        for (basketItem item : basket){
            Orders order = new Orders();
            order.setOrderNumber(orderNum);
            order.setUserID(userID);
            order.setProductID(item.getProduct().getProductID());
            order.setPrice(item.getProduct().getPrice());
            order.setStatus("processing");
            order.setQuantity(item.getQuantity());
            ordersService.saveOrder(order);
        }
        return ("redirect:/");
    }
}
