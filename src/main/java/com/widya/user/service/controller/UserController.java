package com.widya.user.service.controller;

import com.widya.user.service.entity.User;
import com.widya.user.service.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users/{id}")
    public User getDetailUser(@PathVariable Long id) {
        return userService.detailUser(id);
    }

    @PostMapping("/users")
    public User registerNewUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
