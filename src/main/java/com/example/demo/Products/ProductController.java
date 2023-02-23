package com.example.demo.Products;

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

        /*@GetMapping(value = "/product")
        public String getProduct(Model model){
            return "Product/jewellery";
        }*/

        @GetMapping(value = "/product")
        public String getUsers(Model model) {
            List<Product> product = productService.getProduct();
            model.addAttribute("product", product);
            return "Product/jewellery";
    }
}
