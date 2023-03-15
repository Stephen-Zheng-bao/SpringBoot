package com.example.demo.Products;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {


	List<Product> findByProductTypeContains(String ProductType);
	
	List<Product> findByProductNameContains(String ProductName);
	/*#TODO: Make a way to sort by price*/
	List<Product> findByProductIDOrderByPriceAsc(String ProductName);
	/*#TODO: Make a way to price range*/
	List<Product> findByPriceBetween(String price1,String price2);

	Product findByProductID(String productID);
}
