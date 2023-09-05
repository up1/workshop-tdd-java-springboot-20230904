package com.example.api.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(UserController.class)
class UserControllerMockMvcTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mvc;

    @Test
    void getUserById() {
    }
}