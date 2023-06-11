package com.example.library.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone;
    private String city;
    private String street;
    private int postal_code;
    private int role_id;
}
