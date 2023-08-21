package com.apirest.api.services;

import com.apirest.api.domain.User;

import java.util.List;


public interface UserService {

    User findUserById(Long id);
    List<User> findAll();
}
