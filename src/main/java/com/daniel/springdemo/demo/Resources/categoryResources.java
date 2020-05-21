package com.daniel.springdemo.demo.Resources;

import com.daniel.springdemo.demo.Entities.Category;
import com.daniel.springdemo.demo.Services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class categoryResources {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public ResponseEntity<List<Category>> findAll (){
        return ResponseEntity.ok().body(categoryServices.findAll());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Category> findById (@PathVariable Integer id){
        return ResponseEntity.ok().body(categoryServices.findById(id));
    }

}
