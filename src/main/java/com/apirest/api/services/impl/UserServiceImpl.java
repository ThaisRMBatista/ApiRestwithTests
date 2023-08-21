package com.apirest.api.services.impl;

import com.apirest.api.domain.User;
import com.apirest.api.repositories.UserRepository;
import com.apirest.api.services.UserService;
import com.apirest.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findUserById(Long id) {
        Optional<User> userById = this.repository.findById(id);
        return userById.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public List<User> findAll() {
        return this.repository.findAll();
    }
}
