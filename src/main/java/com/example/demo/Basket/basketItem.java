package com.example.demo.Basket;

import com.example.demo.Products.Product;

public class basketItem {
    private int basketID;
    private Product product;
    private int quantity;

    public basketItem(int basketID,Product product,int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.basketID = basketID;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getBasketID() {
        return basketID;
    }

    public void setBasketID(int basketID) {
        this.basketID = basketID;
    }
}
