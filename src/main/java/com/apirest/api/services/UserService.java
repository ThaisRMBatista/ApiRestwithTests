package com.apirest.api.services;

import com.apirest.api.domain.User;


public interface UserService {

    User findUserById(Long id);
}
