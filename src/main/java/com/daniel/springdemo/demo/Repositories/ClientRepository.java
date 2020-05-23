package com.daniel.springdemo.demo.Repositories;

import com.daniel.springdemo.demo.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
