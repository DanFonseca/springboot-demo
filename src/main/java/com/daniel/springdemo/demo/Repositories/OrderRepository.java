package com.daniel.springdemo.demo.Repositories;

import com.daniel.springdemo.demo.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Integer> {
}
