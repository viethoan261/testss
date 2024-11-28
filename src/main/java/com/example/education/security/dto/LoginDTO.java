package com.example.education.security.dto;

import com.example.education.security.validation.ExistedUser;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {
    @NotBlank(message = "Username can not be blank")
    @ExistedUser(message = "Username is not existed")
    private String username;

    @NotBlank(message = "Password can not be blank")
    private String password;
}
