package com.example.api.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    // GET /user/1
    // http://localhost:8080/user/1
    public UserResponse getUserById(@PathVariable int id) {
        // Call service
        UserResponse result = userService.getById(id);
        // Return response to caller
        return result;
    }

}
