package com.example.demo.Orders;


import com.example.demo.User.User;
import com.example.demo.User.UserRepository;

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.aspectj.weaver.ast.Or;
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

    public int getNewID() {
        return ordersRepository.getPreviousID() + 1;
    }

    public void saveOrder(Orders order) {
        ordersRepository.save(order);
    }

    public void updateOrder(int orderID, String status) {
        Orders order = ordersRepository.findById(orderID).get();
        order.setStatus(status);
        ordersRepository.save(order);

    }

    public List<Orders> getOrderByUserID(Integer idOfCurrentUser) {
        return ordersRepository.findAllByUserID(idOfCurrentUser);
    }

    public String orderTotals() {
        List<Orders> orders = ordersRepository.findAll();
        return Integer.toString(orders.size());
    }

    public Double orderRevenue(){
        List<Orders> orders = ordersRepository.findAll();
        double price = 0;
        for (Orders order:orders){
            price += Double.parseDouble(order.getPrice());
        }
        return price;
    }
    public String orderProcessingTotal(){
        List<Orders> orders = ordersRepository.findByStatus("PROCESSING");
        return Integer.toString(orders.size());
    }
    public String orderDispatchedTotal(){
        List<Orders> orders = ordersRepository.findByStatus("DISPACTCHED");
        return Integer.toString(orders.size());
    }
    public String orderDeliveredTotal(){
        List<Orders> orders = ordersRepository.findByStatus("DELIVERED");
        return Integer.toString(orders.size());
    }
    public String orderCancellationTotal(){
        List<Orders> orders = ordersRepository.findByStatus("CANCELLED");
        return Integer.toString(orders.size());
    }
    public List<Orders> getOrderByOrderNumber(int i) {
        return  ordersRepository.findAllByOrderNumber(i);


    }

    public List<Orders> getByStatus(String name) {
        return ordersRepository.findByStatus(name);
    }
}
