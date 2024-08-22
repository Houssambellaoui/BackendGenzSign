package com.prod.GenZ.controller.auth;

import com.prod.GenZ.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Role role;
    private String numcertif;
}
