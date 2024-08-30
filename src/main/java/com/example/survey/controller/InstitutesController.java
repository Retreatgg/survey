package com.example.survey.controller;

import com.example.survey.dto.InstituteDto;
import com.example.survey.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/institutes")
@RequiredArgsConstructor
public class InstitutesController {

    private final InstituteService instituteService;
    @GetMapping()
    public ResponseEntity<List<InstituteDto>> institutes() {
        return ResponseEntity.ok(instituteService.getInstitutes());
    }
}
