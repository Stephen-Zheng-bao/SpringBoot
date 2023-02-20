package com.example.demo.Products;


import jakarta.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(name = "prod_seq",sequenceName = "prod_seq",allocationSize = 1)
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "prod_seq")

    private String ProductID;
    private String ProductName;
    private String ProductType;
    private String Image;
    private String Description;
    private String Stock;
    private String Price;
    private String Gender;
    private String ManufactureDate;

    public Product(String productID, String productName, String productType, String image, String description, String stock, String price, String gender, String manufactureDate) {
        ProductID = productID;
        ProductName = productName;
        ProductType = productType;
        Image = image;
        Description = description;
        Stock = stock;
        Price = price;
        Gender = gender;
        ManufactureDate = manufactureDate;
    }

    public Product(){

    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getManufactureDate() {
        return ManufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        ManufactureDate = manufactureDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductID='" + ProductID + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", ProductType='" + ProductType + '\'' +
                ", Image='" + Image + '\'' +
                ", Description='" + Description + '\'' +
                ", Stock='" + Stock + '\'' +
                ", Price='" + Price + '\'' +
                ", Gender='" + Gender + '\'' +
                ", ManufactureDate='" + ManufactureDate + '\'' +
                '}';
    }

}
