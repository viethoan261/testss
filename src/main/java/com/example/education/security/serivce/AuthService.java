package com.example.education.security.serivce;

import com.example.education.security.dto.LoginDTO;
import com.example.education.security.dto.RegisterDTO;

public interface AuthService {
    String login(LoginDTO dto);

    boolean register(RegisterDTO dto);
}
