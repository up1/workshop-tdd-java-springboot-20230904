package com.example.api.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Success with get user information by id = 1")
    void getUserById() {
        // Act
        UserResponse result = restTemplate.getForObject("/user/1", UserResponse.class);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("Somkiat", result.getFirtname());
        assertEquals("Pui", result.getLastname());

    }
}