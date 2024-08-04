package com.example.survey.service.impl;

import com.example.survey.model.Authority;
import com.example.survey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.survey.model.User user = userService.findByEmail(username);
        return new User(user.getEmail(), user.getPassword(), getAuthorities(user.getAuthorities()));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(List<Authority> authorityList) {
        return authorityList.stream()
                .map(e -> new SimpleGrantedAuthority(e.getAuthority()))
                .toList();
    }
}
