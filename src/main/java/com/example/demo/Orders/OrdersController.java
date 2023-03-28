package com.example.demo.Orders;


import com.example.demo.Basket.BasketService;
import com.example.demo.Basket.basketItem;
import com.example.demo.Products.ProductService;
import com.example.demo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class OrdersController {

    private final OrdersService ordersService;
    private final UserService userService;
    private final BasketService basketService;
    private ProductService productService;

    @Autowired
    public OrdersController(OrdersService ordersService, UserService userService, BasketService basketService, ProductService productService){
        this.ordersService = ordersService;
        this.userService = userService;
        this.basketService = basketService;
        this.productService = productService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/order")
    public String viewOrder(Model model){
        model.addAttribute("orders", getUserOrders());
        model.addAttribute("product",productService.getProduct());
        return "Order/order";
    }
    public HashMap<Integer, ArrayList<Orders>> getUserOrders(){
        int currentMax = ordersService.getNewID() ;
        System.out.println(currentMax);
        HashMap<Integer,ArrayList<Orders>> orders = new HashMap<Integer,ArrayList<Orders>>();
        
        for (int i=0; i<currentMax;i++){
            List<Orders> listOfOrders = ordersService.getOrderByOrderNumber(i);
            if(listOfOrders.isEmpty()){}

            else if (listOfOrders.get(0).getUserID().equals(userService.getIDOfCurrentUser())) {
                orders.put(listOfOrders.get(0).getOrderNumber(), (ArrayList<Orders>) listOfOrders);
            }
        }

        return  orders;
    }

    @PreAuthorize("hasAuthority('USER')")
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
            order.setStatus("PROCESSING");
            order.setQuantity(item.getQuantity());
            productService.updateStock(item.getProduct(),productService.getStock(item.getProduct().getProductID()) - item.getQuantity());
            generateReport(productService.getStock(item.getProduct().getProductID()));

            ordersService.saveOrder(order);
            basketService.delete(item.getBasketID());
        }
        return ("redirect:/basket");
    }

    private void generateReport(int stock) {
        if (stock<=5){

        }
    }
}
