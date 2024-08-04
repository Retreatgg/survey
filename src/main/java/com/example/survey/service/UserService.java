package com.example.survey.service;

import com.example.survey.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById(Long id);
}
