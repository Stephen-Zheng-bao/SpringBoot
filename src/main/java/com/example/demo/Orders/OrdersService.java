package com.example.demo.Orders;


import com.example.demo.User.User;
import com.example.demo.User.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {


    @Autowired
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository =  ordersRepository;
    }

	public List<Orders> getOrders() {
		return ordersRepository.findAll();
	}
}
