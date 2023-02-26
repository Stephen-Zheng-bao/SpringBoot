package com.example.demo.Admin;

import com.example.demo.Orders.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
	public String Admin(Model model) {
		List<Product> products = productService.getProduct();
		model.addAttribute("products", products);
		model.addAttribute("prodcut", new Product());
		return "/admin/Admin";
	}

	@PostMapping(value = "/admin/productAdd")
	public String createUser(@ModelAttribute Product product, Model model, BindingResult bindingResult) {
		System.out.println(product);
		Product products = productService.createProduct(product);
		return "redirect:/admin";}



	@GetMapping("/admin/orders")
	public String Orders(Model model) {
        List<Orders> orders = orderService.getOrders();
        model.addAttribute("orders", orders);
        model.addAttribute("order", new Orders());
		return "/Admin/Orders";
	}
	@PostMapping("/admin/updateOrder")
	public String updateOrder(@RequestParam String status ,@RequestParam String orderID){
		orderService.updateOrder(Integer.parseInt(orderID),status);
		return "/Admin/Orders";
	}
	@GetMapping("/admin/customers")
	public String Customers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
		return "/Admin/Customers";}

	@GetMapping("/admin/accounts")
	public String Account(Model model) {
		return "/Admin/Account";}

	@GetMapping("/admin/vendors")
	public String Vender(Model model) {
		return "/Admin/Vendors";}


	@PostMapping("/admin/updateProduct")
	public String updateProduct(@RequestParam String ProductId ,@RequestParam String productName,@RequestParam String description, @RequestParam String price) {
		//TODO Add Update Product Logic
		Optional<Product> productFetched = productService.fetchByID(Integer.parseInt(ProductId));
		Product productCast = productFetched.get();
		productCast.setProductName(productName);
		productCast.setPrice(price);
		productCast.setDescription(description);
		productService.updateProduct(productCast);
		return "/Admin/admin";


	}

	@RequestMapping(value = "/admin/delete",method = RequestMethod.POST)
	public String delete_User(@RequestParam String UserId) {
		userService.deleteUser(Integer.parseInt(UserId));
		return "redirect:/admin/customers";
	}

	@PostMapping("/admin/updateRole")
	public String updateRole(@RequestParam String role, @RequestParam String userID) {
		userService.updateRole(Integer.parseInt(userID),role);
		return "redirect:/admin/customers";
	}
	@PostMapping("/admin/deleteProduct")
    public String deleteProduct(@RequestParam String ProductId) {
       productService.deleteProduct(Integer.parseInt(ProductId));
        return "redirect:/admin/customers";
    }




}
