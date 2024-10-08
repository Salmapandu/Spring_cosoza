package com.example.COSOZA.Registration.auth;

import com.example.COSOZA.Registration.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String mobile_phone;
    private String password;
    private Role role;
}
