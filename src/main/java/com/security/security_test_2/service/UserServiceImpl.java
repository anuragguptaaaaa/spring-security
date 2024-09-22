package com.security.security_test_2.service;

import com.security.security_test_2.model.Users;
import com.security.security_test_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
