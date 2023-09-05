package com.example.api.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserGateway userGateway;

    @InjectMocks
    UserService userService;

    @Test
    void userNotFound() {
        // Arrange
        when(userGateway.callApi(2)).thenReturn(Optional.empty());
        // Act and assert
        Exception e = assertThrows(UserNotFoundException.class, () -> {
            userService.getById(2);
        });
        assertEquals("User id=2 not found in our system", e.getMessage());
    }
}