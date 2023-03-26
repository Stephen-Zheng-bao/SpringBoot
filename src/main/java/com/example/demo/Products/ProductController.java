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
import java.util.Optional;


@Controller
    public class ProductController {


        private final ProductService productService;

        @Autowired
        public ProductController(ProductService productService) {
            this.productService = productService;
        }
        @GetMapping("filter/{name}")
        public String filter(@PathVariable String name,Model model) {
            List<Product> product = productService.fetchByType(name);
            model.addAttribute("product", product);
            return "Product/jewellery";
        }
        @PostMapping("search")
        public String search(@RequestParam String name,Model model) {
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
        @GetMapping(value = "/product/{id}")
        public String singleProduct(@PathVariable Integer id,Model model) {

            Optional<Product> product = productService.fetchByID(id);
        model.addAttribute("product", product.get());
        return "Product/product";
    }



}
