package com.example.demo.Products;


import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @SequenceGenerator(name = "prod_seq",sequenceName = "prod_seq",allocationSize = 1)
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "prod_seq")

    private String productID;
    private String productName;
    private String productType;
    private String image;
    private String description;
    private String stock;
    private String price;
    private String gender;

    public Product(String productID, String productName, String productType, String image, String description, String stock, String price, String gender) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.image = image;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.gender = gender;
    }

    public Product(){

    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Product{" +
                "ProductID='" + productID + '\'' +
                ", ProductName='" + productName + '\'' +
                ", ProductType='" + productType + '\'' +
                ", Image='" + image + '\'' +
                ", Description='" + description + '\'' +
                ", Stock='" + stock + '\'' +
                ", Price='" + price + '\'' +
                ", Gender='" + gender + '\'' +
                '}';
    }

}
