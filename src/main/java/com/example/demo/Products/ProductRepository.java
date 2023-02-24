package com.example.demo.Products;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	@Query(value = "SELECT * FROM Product WHERE ProductType = ?1",nativeQuery = true)
	List<Product> findByProductType(String ProductType);
	
	List<Product> findByProductName(String ProductName);

	Product findByProductID(String productID);
}
