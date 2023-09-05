package com.example.api.user;

import com.example.api.user.gateway.UserGatewayResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserGatewayTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    @DisplayName("Success :: to call api from jsonplaceholder.com/users/id")
    void callApi() {
        // Act
        Optional<UserGatewayResponse> result = userGateway.callApi(1);
        // Assert
        assertTrue(result.isPresent());
        assertEquals("Leanne Graham", result.get().getName());
    }
}