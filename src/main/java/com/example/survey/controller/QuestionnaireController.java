package com.example.survey.controller;

import com.example.survey.dto.CreateQuestionnaireDto;
import com.example.survey.dto.QuestionnaireDto;
import com.example.survey.dto.ResultQuestionnaireDto;
import com.example.survey.service.QuestionnaireService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaires")
@RequiredArgsConstructor
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    @GetMapping("{id}")
    public ResponseEntity<QuestionnaireDto> getQuestionnaireById(
            @PathVariable Long id) {
        return ResponseEntity.ok(questionnaireService.getQuestionnaireById(id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("{id}")
    public HttpStatus saveResult(@RequestBody @Valid List<ResultQuestionnaireDto> resultQuestionnaireDto, @PathVariable Long id) {
        questionnaireService.saveResult(resultQuestionnaireDto, id);
        return HttpStatus.OK;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public HttpStatus createQuestionnaire(@RequestBody @Valid CreateQuestionnaireDto create) {
        questionnaireService.create(create);
        return HttpStatus.OK;
    }

    @GetMapping()
    public ResponseEntity<List<QuestionnaireDto>> getQuestionnaires() {
        return ResponseEntity.ok(questionnaireService.getAll());
    }

}
