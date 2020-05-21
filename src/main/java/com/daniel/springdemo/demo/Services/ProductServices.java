package com.daniel.springdemo.demo.Services;

import com.daniel.springdemo.demo.Entities.Product;
import com.daniel.springdemo.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public Product findById (Integer id){
       Optional<Product> value =  productRepository.findById(id);
       return value.get();
    }

    public List<Product> findAll (){
        return productRepository.findAll();
    }
}
