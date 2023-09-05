package com.example.api.user;

import com.example.api.user.gateway.UserGatewayResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
class UserGatewayWithMockApiTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    @DisplayName("Success :: to call api from jsonplaceholder.com/users/id")
    void callApi() {
        // Arrange
        String jsonFromFile = readFromFile("classpath:user_1.json");
        stubFor(get(urlEqualTo("/users/1")).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody(jsonFromFile)));

        // Act
        Optional<UserGatewayResponse> result = userGateway.callApi(1);
        // Assert
        assertTrue(result.isPresent());
        assertEquals("Mock name", result.get().getName());
        assertEquals("Mock username", result.get().getUsername());
    }

    private String readFromFile(String filename) {
        try {
            File file = ResourceUtils.getFile(filename);
            byte[] data = Files.readAllBytes(file.toPath());
            return new String(data);
        } catch (Exception e) {
            return "";
        }
    }
}