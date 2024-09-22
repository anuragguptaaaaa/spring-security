package com.security.security_test_2.service;

import com.security.security_test_2.model.UserPrincipal;
import com.security.security_test_2.model.Users;
import com.security.security_test_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users users= userRepository.findByEmail(username);

        return new UserPrincipal(users);
    }
}
