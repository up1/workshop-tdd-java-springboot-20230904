package com.example.api.user;

import com.example.api.user.gateway.UserGatewayResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
class UserGatewayWithMockApiWithErrorTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    @DisplayName("Error 404 :: to call api from jsonplaceholder.com/users/id")
    void callApi() {
        // Arrange
        stubFor(get(urlEqualTo("/users/2")).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                        .withStatus(404)));

        // Act
        Optional<UserGatewayResponse> result = userGateway.callApi(2);
        // Assert
        assertFalse(result.isPresent());
    }
}