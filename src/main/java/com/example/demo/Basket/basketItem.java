package com.example.demo.Basket;

import com.example.demo.Products.Product;

public class basketItem {
    private Product product;
    private int quantity;

    public basketItem(Product product,int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
