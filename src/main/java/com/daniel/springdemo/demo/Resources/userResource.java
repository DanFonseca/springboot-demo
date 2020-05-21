package com.daniel.springdemo.demo.Resources;

import com.daniel.springdemo.demo.Entities.Client;
import com.daniel.springdemo.demo.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class userResource {
    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> userList = userServices.findAll();
        return  ResponseEntity.ok().body(userList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Client> findById (@PathVariable Integer id){
        Client user  = userServices.findById(id);
        return ResponseEntity.ok().body(user);
    }


}
