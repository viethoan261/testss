package com.example.education.security.serivce;

import com.example.education.model.UserModel;
import com.example.education.repository.UserRepository;
import com.example.education.security.dto.LoginDTO;
import com.example.education.security.dto.RegisterDTO;
import com.example.education.security.jwt.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtHelper jwts;

    @Override
    public String login(LoginDTO dto) {
        // get user info
        Optional<UserModel> userOpt = repository.findByUserName(dto.getUsername());

        String encodedPassword = userOpt.get().getPassword();
//        if (userOpt.get().getIsActive() == false) {
//            return null;
//        }
        if (passwordEncoder.matches(dto.getPassword(), encodedPassword)) {
            return jwts.generateJwtToken(dto.getUsername());
        }
        // check pass
        return null;
    }

    @Transactional
    @Override
    public boolean register(RegisterDTO dto) {
        UserModel user = new UserModel();

        user.setUserName(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setFullName(dto.getFullName());

        repository.save(user);

        return true;
    }
}
