package com.daniel.springdemo.demo.Configuration;

import com.daniel.springdemo.demo.Entities.User;
import com.daniel.springdemo.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Jorge","jorge@gmail.com", "59252913","123");
        User u2 = new User(null, "Claudio","claudio@gmail.com", "55512358","asaAf");
        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
