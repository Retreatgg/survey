package com.example.survey.service.impl;

import com.example.survey.model.User;
import com.example.survey.repository.UserRepository;
import com.example.survey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
