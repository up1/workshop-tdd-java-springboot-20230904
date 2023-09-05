package com.example.api.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Success with get user information by id = 1")
    void getUserById() {
        // Arrange
        String jsonFromFile = readFromFile("classpath:user_1.json");
        stubFor(get(urlEqualTo("/users/1")).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody(jsonFromFile)));

        UserResponse expected = new UserResponse();
        expected.setId(1);
        expected.setFirtname("Mock name");
        expected.setLastname("Mock username");
        // Act
        UserResponse result = restTemplate.getForObject("/user/1", UserResponse.class);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("Mock name", result.getFirtname());
        assertEquals("Mock username", result.getLastname());
        assertEquals(expected, result);
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