package com.daniel.springdemo.demo.Resources;

import com.daniel.springdemo.demo.Entities.Product;
import com.daniel.springdemo.demo.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

    @Autowired
    private ProductServices productServices;

    @GetMapping
    public ResponseEntity<List<Product>> findAll (){
        return ResponseEntity.ok().body(productServices.findAll());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(productServices.findById(id));
    }


    @GetMapping(value = "/sum/{n1}/{n2}")
    public ResponseEntity<Integer> sum(@PathVariable Integer n1, @PathVariable Integer n2){
        Integer r = n1+n2;
        return ResponseEntity.ok().body(r);
    }

    @GetMapping(value = "/sub")
    public ResponseEntity<Integer> sub (@RequestParam  Integer n1,
                                        @RequestParam Integer n2){
        Integer r = n1-n2;
        return ResponseEntity.ok().body(r);
    }
}
