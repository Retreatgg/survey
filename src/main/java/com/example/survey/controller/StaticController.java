package com.example.survey.controller;

import com.example.survey.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
