package com.example.education.security.dto;

import com.example.education.security.validation.NotExistedUser;
import com.example.education.utils.enumm.RoleUser;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RegisterDTO {
    @NotBlank(message = "Username can not be blank")
    @NotExistedUser(message = "Username is existed")
    private String username;

    @NotBlank(message = "Password can not be blank")
    private String password;

    @NotBlank(message = "Full name can not be blank")
    private String fullName;

    @NotNull(message = "Role not null")
    private RoleUser role;
}

