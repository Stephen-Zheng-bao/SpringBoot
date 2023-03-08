package com.example.demo.Basket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BasketRepository extends JpaRepository<Basket,Integer> {
    List<Basket> findByuserID(String id);

    Optional<Basket> findByProductIDAndUserID(Integer productID, Integer idOfCurrentUser);
}
