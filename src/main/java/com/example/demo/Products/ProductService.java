package com.example.demo.Products;


import java.util.HashMap;
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
    public Product createProduct(Product product){return this.productRepository.save(product);}
    public void updateProduct(Product product) {
    	productRepository.save(product);
    }
    public Optional<Product> fetchByID(Integer id) {
    	return productRepository.findById(id);
    }
    public List<Product> fetchByType(String type){
    	return productRepository.findByProductTypeContains(type);
    }
    public List<Product> fetchByName(String name){
    	return productRepository.findByProductNameContains(name);
    }
    public List<Product> getProduct(){return productRepository.findAll();}

    public void deleteProduct(int parseInt) {productRepository.deleteById(parseInt);
    }

    public int getStock(int id) {
        return Integer.valueOf(productRepository.findById(id).get().getStock());
    }

    public void updateStock(Product product,int i) {
        product.setStock(Integer.toString(i));
        productRepository.save(product);
    }
    public HashMap<String,String> generateReport(){
        HashMap<String,String> list = new HashMap<>();
        List<Product> products = productRepository.findAll();
        for (Product item : products){
            list.put(item.getProductName(),item.getStock());
        }
        return list;
    }

}

