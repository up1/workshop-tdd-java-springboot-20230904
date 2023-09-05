package com.example.api.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerWithErrorTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("User not found with UserNotFoundException, code = 404")
    void getUserById() {
        // Arrange
        ErrorResponse expected = new ErrorResponse();
        expected.setMessage("XXX");
        when(userService.getById(2)).thenThrow(new UserNotFoundException("XXX"));
        // Act
        ResponseEntity<ErrorResponse> result = restTemplate.getForEntity("/user/2", ErrorResponse.class);
        // Assert
        assertEquals(404, result.getStatusCode().value());
        assertEquals("XXX", result.getBody().getMessage());
        assertEquals(expected, result.getBody());
    }
}