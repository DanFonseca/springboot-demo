package com.daniel.springdemo.demo.Resources;

import com.daniel.springdemo.demo.Entities.Client;
import com.daniel.springdemo.demo.Services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class ClientResource {
    @Autowired
    private ClientServices clientServices;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> userList = clientServices.findAll();
        return  ResponseEntity.ok().body(userList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Client> findById (@PathVariable Integer id){
        Client user  = clientServices.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<Client> insert (@RequestBody Client client){
        Client c = clientServices.insert(client);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(location).body(c);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removeById(@PathVariable Integer id){
        clientServices.removeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update (@PathVariable Integer id, @RequestBody Client client){
       return ResponseEntity.ok().body(clientServices.update(client, id));
    }


}
