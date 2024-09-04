package com.example.survey.service;

import com.example.survey.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionnaireService {
    QuestionnaireDto getQuestionnaireById(Long id);
    List<QuestionAnswersDto> getAnswersByQuestionnaireId(Long id, String instituteName);
    void saveResult(List<ResultQuestionnaireDto> resultQuestionnaireDto, Long id);
    void create(CreateQuestionnaireDto create);
    List<QuestionnaireShowDto> getAll();
}
