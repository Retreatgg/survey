package com.example.survey.service;

import com.example.survey.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User findById(Long id);

    User findByEmail(String username);
}
