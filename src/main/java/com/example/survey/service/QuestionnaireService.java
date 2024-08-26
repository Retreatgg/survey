package com.example.survey.service;

import com.example.survey.dto.CreateQuestionnaireDto;
import com.example.survey.dto.QuestionAnswersDto;
import com.example.survey.dto.QuestionnaireDto;
import com.example.survey.dto.ResultQuestionnaireDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionnaireService {
    QuestionnaireDto getQuestionnaireById(Long id, String institute);

    List<QuestionAnswersDto> getAnswersByQuestionnaireId(Long id, String institute);

    void saveResult(List<ResultQuestionnaireDto> resultQuestionnaireDto, Long id);

    void create(CreateQuestionnaireDto create);
}
