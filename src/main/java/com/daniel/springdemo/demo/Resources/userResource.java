package com.daniel.springdemo.demo.Resources;

import com.daniel.springdemo.demo.Entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class userResource {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1, "Maria", "maria@gmail.com", "99999", "123");
        return ResponseEntity.ok().body(u);
    }

}
