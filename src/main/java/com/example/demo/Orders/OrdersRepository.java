package com.example.demo.Orders;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    @Query(value = "SELECT MAX(order_number) FROM past_order", nativeQuery = true)
    int getPreviousID();

    List<Orders> findAllByUserID(Integer id);


    List<Orders> findByStatus(String processing);

    List<Orders> findAllByOrderNumber(Integer id);
}
