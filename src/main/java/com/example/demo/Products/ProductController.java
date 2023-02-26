package com.example.demo.Products;

import com.example.demo.User.User;
import com.example.demo.User.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
    public class ProductController {


        private final ProductService productService;

        @Autowired
        public ProductController(ProductService productService) {
            this.productService = productService;
        }
        @GetMapping("/filter")
        @ResponseBody
        public List<Product> filter(@RequestParam String type) {
        	return productService.fetchByType(type);
        }
        @GetMapping("/search")
        @ResponseBody
        public List<Product> search(@RequestParam String name) {
        	return productService.fetchByName(name);
        }

        /*@GetMapping(value = "/product")
        public String getProduct(Model model){
            return "Product/jewellery";
        }*/

        @GetMapping(value = "/product")
        public String product(Model model) {
            List<Product> product = productService.getProduct();
            model.addAttribute("product", product);
            return "Product/jewellery";
    }




}
