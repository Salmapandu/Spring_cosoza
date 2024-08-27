package com.example.COSOZA.Registration.dto;

import com.example.COSOZA.Registration.Entity.Role;
import lombok.Data;

@Data
public class RegistrationDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String mobile_phone;
    private String password;
    private Role role; // Adjust this if needed
}
