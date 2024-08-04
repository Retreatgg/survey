package com.example.survey.service;

import com.example.survey.dto.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    ResponseEntity<?> createAuthToken(JwtRequest authRequest);
}
