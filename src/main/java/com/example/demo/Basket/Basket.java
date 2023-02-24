package com.example.demo.Basket;


import jakarta.persistence.*;

@Entity
@Table

public class Basket {

    @Id
    @SequenceGenerator(name = "bask_seq",sequenceName = "bask_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bask_seq")
    private Integer basketID;
    private Integer userID;
    private Integer productID;
    private Integer quantity;
    private String price;

    public Basket(Integer basketID, Integer userID, Integer productID, Integer quantity, String price) {
        this.basketID = basketID;
        this.userID = userID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public Basket(){

    }

    public Integer getOrdersID() {
        return basketID;
    }

    public void setOrdersID(Integer ordersID) {
        basketID = ordersID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "OrdersID=" + basketID +
                ", UserID=" + userID +
                ", ProductID=" + productID +
                ", Quantity=" + quantity +
                ", Price='" + price + '\'' +
                '}';
    }
}
