package com.apirest.api.services;

import com.apirest.api.domain.User;
import com.apirest.api.domain.dto.UserDTO;

import java.util.List;


public interface UserService {

    User findUserById(Long id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Long id);
}
