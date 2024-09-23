package com.security.security_test_2.service;

import com.security.security_test_2.model.Users;
import com.security.security_test_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService; // Inject UserDetailsService to load UserDetails

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);
    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users registerUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return  userRepository.save(user);
    }

    @Override
    public String varifyUser(Users user) {

        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
       if(authentication.isAuthenticated()){
           UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

           return jwtService.generateToken(userDetails);
       }else {
           return "failed";
       }
    }
}
