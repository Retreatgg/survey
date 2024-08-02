package com.example.survey.service;

import com.example.survey.dto.CreateQuestionnaireDto;
import com.example.survey.dto.QuestionAnswersDto;
import com.example.survey.dto.QuestionnaireDto;
import com.example.survey.dto.ResultQuestionnaireDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionnaireService {
    QuestionnaireDto getQuestionnaireById(Long id);

    List<QuestionAnswersDto> getAnswersByQuestionnaireId(Long id);

    void saveResult(List<ResultQuestionnaireDto> resultQuestionnaireDto, Long id);

    void create(CreateQuestionnaireDto create);
}
