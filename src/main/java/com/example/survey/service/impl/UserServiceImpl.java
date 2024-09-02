package com.example.survey.service.impl;

import com.example.survey.exceptions.UserNotFoundException;
import com.example.survey.model.User;
import com.example.survey.repository.UserRepository;
import com.example.survey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователь с ID: " + id + " не найден"));
    }

    @Override
    public User findByEmail(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с email: + " + username + " не найден"));
    }
}
