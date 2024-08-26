package com.example.survey.service.impl;

import com.example.survey.model.Institute;
import com.example.survey.repository.InstituteRepository;
import com.example.survey.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstituteServiceImpl implements InstituteService {

    private final InstituteRepository instituteRepository;

    @Override
    public Institute getInstituteById(Long instituteId) {
        return instituteRepository.findById(instituteId)
                .orElseThrow();
    }
}
