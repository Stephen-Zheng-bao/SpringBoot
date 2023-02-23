package com.example.demo.Basket;


import jakarta.persistence.*;

@Entity
@Table

public class Basket {

    @Id
    @SequenceGenerator(name = "bask_seq",sequenceName = "bask_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bask_seq")
    private Integer BasketID;
    private Integer UserID;
    private Integer ProductID;
    private Integer Quantity;
    private String Price;

    public Basket(Integer basketID, Integer userID, Integer productID, Integer quantity, String price) {
        BasketID = basketID;
        UserID = userID;
        ProductID = productID;
        Quantity = quantity;
        Price = price;
    }

    public Basket(){

    }

    public Integer getOrdersID() {
        return BasketID;
    }

    public void setOrdersID(Integer ordersID) {
        BasketID = ordersID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "OrdersID=" + BasketID +
                ", UserID=" + UserID +
                ", ProductID=" + ProductID +
                ", Quantity=" + Quantity +
                ", Price='" + Price + '\'' +
                '}';
    }
}
