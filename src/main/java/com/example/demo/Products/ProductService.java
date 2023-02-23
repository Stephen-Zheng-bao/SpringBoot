package com.example.demo.Products;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void updateProduct(Product product) {
    	productRepository.save(product);
    }
    public Optional<Product> fetchByID(Integer id) {
    	return productRepository.findById(id);
    }
    public List<Product> getProduct(){return productRepository.findAll();}

}

