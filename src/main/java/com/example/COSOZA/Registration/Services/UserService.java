package com.example.COSOZA.Registration.Services;

import com.example.COSOZA.Registration.Entity.User;
import com.example.COSOZA.Registration.Repository.UserRepository;
import com.example.COSOZA.Registration.dto.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    private BCryptPasswordEncoder passwordEncoder;

    public void registerUser(RegistrationDTO registrationDTO) {
        User user = new User();
        user.setFirstname(registrationDTO.getFirstname());
        user.setLastname(registrationDTO.getLastname());
        user.setEmail(registrationDTO.getEmail());
        user.setAddress(registrationDTO.getAddress());
        user.setMobile_phone(registrationDTO.getMobile_phone());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setRole(registrationDTO.getRole());

        // Check for existing user
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User with email already exists");
        }

        userRepository.save(user);
    }
}