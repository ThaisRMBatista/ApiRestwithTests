package com.apirest.api.controllers.exceptions;

import com.apirest.api.services.exceptions.DataIntegrityViolationException;
import com.apirest.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ControllerExceptionHandlerTest {

    public static final String USUARIO_NAO_ENCONTRADO = "Usuário não encontrado";
    public static final String E_MAIL_JA_CADASTRADO_NO_SISTEMA = "E-mail já cadastrado no sistema";


    @InjectMocks
    private ControllerExceptionHandler controllerExceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenObjectNotFoundExceptionThenReturnAResponseEntity() {
        ResponseEntity<StandardError> response = controllerExceptionHandler.objectNotFound(
                new ObjectNotFoundException(USUARIO_NAO_ENCONTRADO),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(USUARIO_NAO_ENCONTRADO, response.getBody().getErrors());
        assertEquals(404, response.getBody().getStatus());
        assertNotEquals("/users/2", response.getBody().getPath());
        assertNotEquals(LocalDateTime.now(), response.getBody().getTimestamp());
    }

    @Test
    void dataIntegrityViolation() {
        ResponseEntity<StandardError> response = controllerExceptionHandler.dataIntegrityViolation(
                new DataIntegrityViolationException(E_MAIL_JA_CADASTRADO_NO_SISTEMA),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(400, response.getBody().getStatus());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(E_MAIL_JA_CADASTRADO_NO_SISTEMA, response.getBody().getErrors());
    }
}