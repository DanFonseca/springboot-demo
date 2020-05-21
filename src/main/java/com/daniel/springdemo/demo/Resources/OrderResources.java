package com.daniel.springdemo.demo.Resources;

import com.daniel.springdemo.demo.Entities.Order;
import com.daniel.springdemo.demo.Services.OrderServices;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {
    @Autowired
    private OrderServices orderServices;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(orderServices.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll (){
        return ResponseEntity.ok().body(orderServices.findAll());
    }
}
