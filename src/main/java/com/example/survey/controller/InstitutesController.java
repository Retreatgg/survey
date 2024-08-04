package com.example.survey.controller;

import com.example.survey.enums.Institutes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/institutes")
public class InstitutesController {

    @GetMapping()
    public ResponseEntity<List<String>> institutes() {
        List<Institutes> institutes = List.of(Institutes.values());
        return ResponseEntity.ok(institutes.stream().map(Institutes::toString).toList());
    }
}
