package com.example.api.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    // GET /user/1
    // http://localhost:8080/user/1
    public UserResponse getUserById(@PathVariable int id) {
        return new UserResponse();
    }

}
