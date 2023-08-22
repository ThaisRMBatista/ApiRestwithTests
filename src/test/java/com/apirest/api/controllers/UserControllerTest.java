package com.apirest.api.controllers;

import com.apirest.api.domain.User;
import com.apirest.api.domain.dto.UserDTO;
import com.apirest.api.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

    public static final Long    ID          = 1L;
    public static final String  NAME        = "Amanda";
    public static final String  EMAIL       = "amanda@gmail.com";
    public static final String  PASSWORD    = "123";
    public static final String USUARIO_NAO_ENCONTRADO = "Usuário não encontrado";
    public static final int INDEX = 0;
    public static final String E_MAIL_JA_CADASTRADO_NO_SISTEMA = "E-mail já cadastrado no sistema";

    @InjectMocks
    private UserController controller;

    @Mock
    private ModelMapper mapper;

    @Mock
    private UserServiceImpl service;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void testUpdate() {
    }

    private void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}