package com.security.security_test_2.controller;

import com.security.security_test_2.model.Users;
import com.security.security_test_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
