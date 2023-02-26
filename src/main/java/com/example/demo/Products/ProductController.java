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
        @PostMapping("/filter")
        public String filter(@RequestParam String type,Model model) {
            List<Product> product = productService.fetchByType(type);
            model.addAttribute("product", product);
            return "Product/jewellery";
        }
        @PostMapping("/search")
        public String search(@PathVariable("name") @RequestParam String name,Model model) {
            List<Product> product = productService.fetchByName(name);
            model.addAttribute("product", product);
            return "Product/jewellery";
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
