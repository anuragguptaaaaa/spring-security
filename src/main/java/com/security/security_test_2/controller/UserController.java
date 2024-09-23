package com.security.security_test_2.controller;

import com.security.security_test_2.model.Users;
import com.security.security_test_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("register")
    public Users registerUser(@RequestBody Users user) {
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        System.out.println("login");
        System.out.println(user.toString());

        return userService.varifyUser(user);
    }
}
