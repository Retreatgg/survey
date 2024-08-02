package com.example.survey.service;

import com.example.survey.dto.CreateQuestionDto;
import com.example.survey.dto.QuestionDto;
import com.example.survey.model.Questionnaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    List<QuestionDto> getQuestionByQuestionnaireId(Long questionnaireId);

    void createQuestions(List<CreateQuestionDto> questions, Questionnaire questionnaire);
}
