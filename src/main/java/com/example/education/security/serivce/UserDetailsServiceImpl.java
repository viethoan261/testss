package com.example.education.security.serivce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.education.model.UserModel;
import com.example.education.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userOpt = repository.findByUserName(username);
        if (userOpt.isEmpty())
            return null;
        UserModel currentUser = userOpt.get();

        return new User(currentUser.getUserName(), currentUser.getPassword(), getGrantedAuthorities(currentUser));
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserModel user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return authorities;
    }

}
