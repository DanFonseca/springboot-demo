package com.daniel.springdemo.demo.Services;

import com.daniel.springdemo.demo.Entities.Order;
import com.daniel.springdemo.demo.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    public Order findById (Integer id){
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }

    public List<Order> findAll (){
        List<Order> orderList = orderRepository.findAll();
        System.out.println(orderList);
        return orderRepository.findAll();
    }

}
