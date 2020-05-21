package com.daniel.springdemo.demo.Configuration;

import com.daniel.springdemo.demo.Entities.Order;
import com.daniel.springdemo.demo.Entities.Client;
import com.daniel.springdemo.demo.Repositories.OrderRepository;
import com.daniel.springdemo.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        Client u1 = new Client(null, "Jorge","jorge@gmail.com", "59252913","123");
        Client u2 = new Client(null, "Claudio","claudio@gmail.com", "55512358","asaAf");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
