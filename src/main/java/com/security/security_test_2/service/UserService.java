package com.security.security_test_2.service;

import com.security.security_test_2.model.Users;

import java.util.List;

public interface UserService {
     List<Users> getAllUsers();

    Users registerUser(Users user);

    String varifyUser(Users user);
}
