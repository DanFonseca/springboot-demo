package com.daniel.springdemo.demo.Services;

import com.daniel.springdemo.demo.Entities.Category;
import com.daniel.springdemo.demo.Entities.Order;
import com.daniel.springdemo.demo.Repositories.CategoryRepository;
import com.daniel.springdemo.demo.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById (Integer id){
       Optional<Category> value =  categoryRepository.findById(id);
       return value.get();
    }

    public List<Category> findAll (){
        return categoryRepository.findAll();
    }
}
