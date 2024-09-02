package com.example.survey.controller;

import com.example.survey.dto.QuestionnaireDto;
import com.example.survey.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/statics/questionnaires")
public class StaticController {

    private final QuestionnaireService questionnaireService;

    @GetMapping("{id}")
    public Object getQuestionAnswerPercentages(
            @PathVariable Long id,
            @RequestParam(name = "institute", defaultValue = "default") String institute) {
        return questionnaireService.getAnswersByQuestionnaireId(id, institute);
    }

}
