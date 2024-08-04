package com.example.survey.controller;

import com.example.survey.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/statics/questionnaires")
public class StaticController {

    private final QuestionnaireService questionnaireService;

    @GetMapping("{id}")
    public Object getQuestionAnswerPercentages(@PathVariable Long id) {
        return questionnaireService.getAnswersByQuestionnaireId(id);
    }

}
