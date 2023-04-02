package com.example.demo.Admin;

import com.example.demo.Basket.Basket;
import com.example.demo.Basket.BasketService;
import com.example.demo.Orders.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import  java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.websocket.WsIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Orders.OrdersService;
import com.example.demo.Products.Product;
import com.example.demo.Products.ProductService;
import com.example.demo.User.User;
import com.example.demo.User.UserService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdminController {
	@Autowired
	 private final UserService userService;
	private final ProductService productService;
	private final OrdersService orderService;
	private final BasketService basketService;
	public AdminController(UserService userService, ProductService productService, OrdersService orderService,BasketService basketService) {
		this.userService = userService;
		this.productService = productService;
		this.orderService = orderService;
		this.basketService = basketService;
		
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin")
	public String Admin(Model model) {
		List<Product> products = productService.getProduct();
		model.addAttribute("products", products);
		model.addAttribute("product", new Product());
		model.addAttribute("Revenue",orderService.orderRevenue());
		model.addAttribute("Sale",orderService.orderTotals());
		model.addAttribute("Process",orderService.orderProcessingTotal());
		model.addAttribute("Dispactched",orderService.orderDispatchedTotal());
		model.addAttribute("Delivered",orderService.orderDeliveredTotal());
		model.addAttribute("Cancellations",orderService.orderCancellationTotal());
		return "Admin/Admin";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/admin/productAdd")
	public String createUser(@ModelAttribute Product product, Model model, BindingResult bindingResult,@RequestParam("imageTest") MultipartFile file) throws IOException {
		System.out.println(product);
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		file.transferTo(new File(  System.getProperty("user.dir")+ "/src/main/resources/static/images/" + filename));
		product.setImage(filename);
		Product products = productService.createProduct(product);
		return "redirect:/admin";}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/testSave")
	public String testSave(){
		return ("imageTest.html");
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/save")
	public RedirectView saveImage(@RequestParam("image") MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		file.transferTo(new File(  System.getProperty("user.dir")+ "/src/main/resources/static/images/" + filename)); // DO NOT EDIT THIS WON'T WORK LOCALLY BUT WORKS ON THE SERVER
		return new RedirectView("/");
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/orders")
	public String Orders(Model model) {
        List<Orders> orders = orderService.getOrders();
        model.addAttribute("orders", getOrders());
        model.addAttribute("order", new Orders());
		return "Admin/Orders";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/admin/orders/searchOrder")
	public String searchOrder(@RequestParam String name,Model model) {
		List<Orders> orders = orderService.getByStatus(name);
		model.addAttribute("orders", getOrders(name));
		return "Admin/Orders";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/admin/orders/filterOrder")
	public String filterOrder(@RequestParam String name,Model model) {
		List<Orders> orders = orderService.getByStatus(name);
		model.addAttribute("orders", getOrders(name));
		return "Admin/Orders";
	}
	public HashMap<Integer, ArrayList<Orders>> getOrders(String name){
		int currentMax = orderService.getNewID() ;
		System.out.println(currentMax);
		HashMap<Integer,ArrayList<Orders>> orders = new HashMap<Integer,ArrayList<Orders>>();
		for (int i=0; i<currentMax;i++){

			List<Orders> listOfOrders = orderService.getOrderByOrderNumber(i);
			if(listOfOrders.get(0).getStatus().equals(name)){
			orders.put(listOfOrders.get(0).getOrderNumber(), (ArrayList<Orders>) listOfOrders);
		}}
		return  orders;
	}


	/* Stephen here is the code just add the mapping you want for it */
	public HashMap<Integer, ArrayList<Orders>> getOrders(){
		int currentMax = orderService.getNewID() ;
		System.out.println(currentMax);
		HashMap<Integer,ArrayList<Orders>> orders = new HashMap<Integer,ArrayList<Orders>>();
		for (int i=0; i<currentMax;i++){
			List<Orders> listOfOrders = orderService.getOrderByOrderNumber(i);
			orders.put(listOfOrders.get(0).getOrderNumber(), (ArrayList<Orders>) listOfOrders);
		}
		return  orders;
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/admin/updateOrder")
	public String updateOrder(@RequestParam String status ,@RequestParam String orderNumber){
		List<Orders> orders = orderService.getOrderByOrderNumber(Integer.valueOf(orderNumber));
		for (Orders i : orders){
			i.setStatus(status);
			orderService.saveOrder(i);
		}
		return "redirect:/admin/orders";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/customers")
	public String Customers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
		return "Admin/Customers";}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/accounts")
	public String Account(Model model) {
		return "Admin/Account";}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/vendors")
	public String Vender(Model model) {
		return "Admin/Vendors";}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/generateReport")
	@ResponseBody
	public HashMap<String,Object> generateReport(){
		HashMap<String,Object> infomationToSend = new HashMap<String,Object>();
		infomationToSend.put("totalOrders", orderService.orderTotals());
		infomationToSend.put("totalProcessing",orderService.orderProcessingTotal());
		infomationToSend.put("totalDispatched",orderService.orderDispatchedTotal());
		infomationToSend.put("stock",productService.generateReport());
		return infomationToSend;
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/admin/updateProduct")
	public String updateProduct(@RequestParam String ProductId ,@RequestParam String productName,@RequestParam String description, @RequestParam String price) {
		//TODO Add Update Product Logic
		Optional<Product> productFetched = productService.fetchByID(Integer.parseInt(ProductId));
		Product productCast = productFetched.get();
		productCast.setProductName(productName);
		productCast.setPrice(price);
		productCast.setDescription(description);
		productService.updateProduct(productCast);
		return "Admin/Admin";


	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/admin/customerSearch")
	public String searchCustomer(@RequestParam String name,Model model) {
		List<User> users = userService.fetchByName(name);
		model.addAttribute("users", users);
		return "Admin/Customers";


	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/filter")
	public String filter(@RequestParam String name,Model model) {
		List<Product> products = productService.fetchByType(name);
		model.addAttribute("products", products);
		model.addAttribute("product", new Product());
		model.addAttribute("Revenue",orderService.orderRevenue());
		model.addAttribute("Sale",orderService.orderTotals());
		model.addAttribute("Process",orderService.orderProcessingTotal());
		model.addAttribute("Dispactched",orderService.orderDispatchedTotal());
		model.addAttribute("Delivered",orderService.orderDeliveredTotal());
		model.addAttribute("Cancellations",orderService.orderCancellationTotal());
		return "Admin/Admin";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/admin/search")
	public String search(@RequestParam String name,Model model) {
		List<Product> products = productService.fetchByName(name);
		model.addAttribute("products", products);
		model.addAttribute("product", new Product());
		model.addAttribute("Revenue",orderService.orderRevenue());
		model.addAttribute("Sale",orderService.orderTotals());
		model.addAttribute("Process",orderService.orderProcessingTotal());
		model.addAttribute("Dispactched",orderService.orderDispatchedTotal());
		model.addAttribute("Delivered",orderService.orderDeliveredTotal());
		model.addAttribute("Cancellations",orderService.orderCancellationTotal());
		return "Admin/Admin";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/admin/delete",method = RequestMethod.POST)
	public String delete_User(@RequestParam String UserId) {
		userService.deleteUser(Integer.parseInt(UserId));
		return "redirect:/admin/customers";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/admin/updateRole")
	public String updateRole(@RequestParam String role, @RequestParam String userID) {
		userService.updateRole(Integer.parseInt(userID),role);
		return "redirect:/admin/customers";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/admin/deleteProduct")
    public String deleteProduct(@RequestParam String ProductId) {
       productService.deleteProduct(Integer.parseInt(ProductId));
        return "redirect:/admin";
    }
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/admin/addQua")
	public String  addToBasket(@RequestParam String productID, @RequestParam String stock, RedirectAttributes redirectAttributes, HttpServletRequest request ) {
		Product product = productService.fetchByID(Integer.valueOf(productID)).get();
		product.setStock(String.valueOf(Integer.parseInt(product.getStock())+Integer.parseInt(stock)));
		productService.updateProduct(product);
		return "redirect:/admin";
	}


}
