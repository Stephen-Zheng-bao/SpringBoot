package com.example.demo.Admin;

import com.example.demo.Orders.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Orders.OrdersService;
import com.example.demo.Products.Product;
import com.example.demo.Products.ProductService;
import com.example.demo.User.User;
import com.example.demo.User.UserService;

@Controller
public class AdminController {
	@Autowired
	 private final UserService userService;
	private final ProductService productService;
	private final OrdersService orderService;
	public AdminController(UserService userService, ProductService productService, OrdersService orderService) {
		this.userService = userService;
		this.productService = productService;
		this.orderService = orderService;
		
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin")
	public String Admin() {
		return "/admin/admin";
	}
	@GetMapping("/admin/orders")
	public String Orders(Model model) {
        List<Orders> orders = orderService.getOrders();
        model.addAttribute("products", orders);
        model.addAttribute("user", new Orders());
		return "/admin/Orders";
	}
	@GetMapping("/admin/Customers")
	public String Customers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
		return "/admin/Customers";
	}
	@PostMapping("/admin/updateProduct")
	public String updateProduct(@RequestParam String ProductId ,@RequestParam String productName,@RequestParam String description, @RequestParam String price) {
		//TODO Add Update Product Logic
		Optional<Product> productFetched = productService.fetchByID(Integer.parseInt(ProductId));
		Product productCast = productFetched.get();
		productCast.setProductName(productName);
		productCast.setPrice(price);
		productCast.setDescription(description);
		productService.updateProduct(productCast);
		return "/admin/admin"; 
	}
	/*@PostMapping("/admin/updateRole")
	public String updateRole(@RequestParam String role, @RequestParam String userID) {
		userService.updateRole(Integer.parseInt(userID),role);
		return "/admin/admin";
	}*/
	@PostMapping("/admin/deleteProduct")
    public String deleteProduct(@RequestParam String ProductId) {
       // ProductService.deleteProduct(Integer.parseInt(ProductId));
        return "redirect:/admin";
    }
}
