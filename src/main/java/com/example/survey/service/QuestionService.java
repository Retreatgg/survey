package com.example.survey.service;

import com.example.survey.dto.CreateQuestionDto;
import com.example.survey.dto.QuestionDto;
import com.example.survey.model.Question;
import com.example.survey.model.Questionnaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    Question findById(Long questionId);
    List<QuestionDto> getQuestionByQuestionnaireId(Long questionnaireId);
    void createQuestions(List<CreateQuestionDto> questions, Questionnaire questionnaire);
}
