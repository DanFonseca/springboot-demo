package com.daniel.springdemo.demo.Repositories;

import com.daniel.springdemo.demo.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Integer> {
}
