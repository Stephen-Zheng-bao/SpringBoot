package com.example.demo.Basket;


import com.example.demo.Products.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.User.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class BasketController {

private final  BasketService basketService;
private final UserService userService;
    private ProductService productService;

    @Autowired
    public BasketController(BasketService basketService, UserService userService, ProductService productService){
        this.basketService = basketService;
		this.userService = userService;
        this.productService = productService;
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
        double total = 0.0;
        for (basketItem stuff:basket){
            total += stuff.total();
        }
        System.out.println(String.format("%.2f",total));
        model.addAttribute("Total",String.format("%.2f",total));
        return "Basket/basket";
    }
    /*
    * Adds an item to the basket
    * */
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/addToBasket")
        public RedirectView addToBasket(@RequestParam String productID, @RequestParam String quantity, @RequestParam String price, RedirectAttributes redirectAttributes, HttpServletRequest request ){
        System.out.println(quantity);
        Basket itemAdd;
        Optional<Basket> basket = basketService.getBasketByProductID(Integer.valueOf(productID),userService.getIDOfCurrentUser());
        if (basket.isPresent()){
            itemAdd = basket.get();
            itemAdd.setQuantity(itemAdd.getQuantity()+Integer.parseInt(quantity));
        }
        else {
            itemAdd = new Basket();
            itemAdd.setQuantity(Integer.valueOf(quantity));
        }
        if ((productService.getStock(Integer.valueOf(productID))- itemAdd.getQuantity() < 0)){
            redirectAttributes.addFlashAttribute("error","Out of Stock");
            return new RedirectView(request.getHeader("Referer"),true);
        }
        itemAdd.setProductID(Integer.valueOf(productID));
        //itemAdd.setQuantity(Integer.valueOf(quantity));
        //itemAdd.setQuantity(1);
        itemAdd.setUserID(userService.getIDOfCurrentUser());
        itemAdd.setPrice(price);
        basketService.createBasket(itemAdd);
        return new RedirectView(request.getHeader("Referer"),true);
    }

}
