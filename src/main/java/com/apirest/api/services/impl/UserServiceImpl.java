package com.apirest.api.services.impl;

import com.apirest.api.domain.User;
import com.apirest.api.repositories.UserRepository;
import com.apirest.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findUserById(Long id) {
        Optional<User> userById = this.repository.findById(id);
        return userById.orElse(null);
    }
}
