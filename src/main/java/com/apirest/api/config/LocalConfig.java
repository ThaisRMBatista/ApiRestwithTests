package com.apirest.api.config;

import com.apirest.api.domain.User;
import com.apirest.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void startDB() {
        User user1 = new User(null, "Regina Maria", "regina@gmail.com", "123");
        User user2 = new User(null, "Thaís Regina", "thais@gmail.com", "321");

        userRepository.saveAll(List.of(user1,user2));
    }
}
