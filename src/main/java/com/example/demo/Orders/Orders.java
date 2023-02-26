package com.example.demo.Orders;


import jakarta.persistence.*;

@Entity
@Table(name = "past_order")
public class Orders {
    @Id
    @SequenceGenerator(name = "orde_seq",sequenceName = "orde_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orde_seq")

    private Integer orderID;
    private Integer orderNumber;
    private Integer userID;
    private Integer productID;
    private Integer quantity;
    private String price;
    private String status;

    public Orders(Integer ordersID, Integer orderNumber, Integer userID, Integer productID, Integer quantity, String price, String status) {
        this.orderID = ordersID;
        this.orderNumber = orderNumber;
        this.userID = userID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public Orders(){

    }

    public Integer getOrdersID() {
        return orderID;
    }

    public void setOrdersID(Integer ordersID) {
        this.orderID = ordersID;
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
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "OrdersID=" + orderID +
                ", UserID=" + userID +
                ", ProductID=" + productID +
                ", Quantity=" + quantity +
                ", Price='" + price + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
}
