package com.daniel.springdemo.demo.Repositories;

import com.daniel.springdemo.demo.Entities.Category;
import com.daniel.springdemo.demo.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
