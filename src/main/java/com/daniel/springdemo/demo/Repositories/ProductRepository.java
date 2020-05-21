package com.daniel.springdemo.demo.Repositories;

import com.daniel.springdemo.demo.Entities.Category;
import com.daniel.springdemo.demo.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
