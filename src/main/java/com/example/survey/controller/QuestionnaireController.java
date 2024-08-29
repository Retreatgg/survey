package com.example.survey.controller;

import com.example.survey.dto.CreateQuestionnaireDto;
import com.example.survey.dto.QuestionnaireDto;
import com.example.survey.dto.ResultQuestionnaireDto;
import com.example.survey.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questionnaires")
@RequiredArgsConstructor
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    @GetMapping("{id}")
    public ResponseEntity<QuestionnaireDto> getQuestionnaireById(
            @PathVariable Long id) {
        return ResponseEntity.ok(questionnaireService.getQuestionnaireById(id));
    }

    @PostMapping("{id}")
    public HttpStatus saveResult(@RequestBody List<ResultQuestionnaireDto> resultQuestionnaireDto, @PathVariable Long id) {
        questionnaireService.saveResult(resultQuestionnaireDto, id);
        return HttpStatus.OK;
    }

    @PostMapping("")
    public HttpStatus createQuestionnaire(@RequestBody CreateQuestionnaireDto create) {
        questionnaireService.create(create);
        return HttpStatus.OK;
    }

}
