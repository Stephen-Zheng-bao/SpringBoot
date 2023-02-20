package com.example.demo.Orders;


import jakarta.persistence.*;

@Entity
@Table
public class Orders {
    @Id
    @SequenceGenerator(name = "orde_seq",sequenceName = "orde_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orde_seq")

    private Integer OrdersID;
    private Integer UserID;
    private Integer ProductID;
    private Integer Quantity;
    private String Price;
    private String Status;

    public Orders(Integer ordersID, Integer userID, Integer productID, Integer quantity, String price, String status) {
        OrdersID = ordersID;
        UserID = userID;
        ProductID = productID;
        Quantity = quantity;
        Price = price;
        Status = status;
    }

    public Orders(){

    }

    public Integer getOrdersID() {
        return OrdersID;
    }

    public void setOrdersID(Integer ordersID) {
        OrdersID = ordersID;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "OrdersID=" + OrdersID +
                ", UserID=" + UserID +
                ", ProductID=" + ProductID +
                ", Quantity=" + Quantity +
                ", Price='" + Price + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
