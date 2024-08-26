package com.example.survey.service.impl;

import com.example.survey.dto.InstituteDto;
import com.example.survey.model.Institute;
import com.example.survey.repository.InstituteRepository;
import com.example.survey.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstituteServiceImpl implements InstituteService {

    private final InstituteRepository instituteRepository;

    @Override
    public Institute getInstituteById(Long instituteId) {
        return instituteRepository.findById(instituteId)
                .orElseThrow();
    }

    @Override
    public List<InstituteDto> getInstitutes() {
        List<Institute> institutes = instituteRepository.findAll();
        return institutes.stream()
                .map(this::toDto)
                .toList();
    }

    private InstituteDto toDto(Institute institute) {
        return InstituteDto.builder()
                .name(institute.getName())
                .id(institute.getId())
                .build();
    }
}
