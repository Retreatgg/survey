package com.example.survey.service.impl;

import com.example.survey.dto.CreateQuestionDto;
import com.example.survey.dto.QuestionDto;
import com.example.survey.exceptions.QuestionNotFoundException;
import com.example.survey.model.Question;
import com.example.survey.model.Questionnaire;
import com.example.survey.repository.QuestionRepository;
import com.example.survey.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final DtoBuilder dtoBuilder;

    @Override
    public Question findById(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException("Вопрос с ID: " + questionId + " не найден"));
    }

    @Override
    public List<QuestionDto> getQuestionByQuestionnaireId(Long questionnaireId) {
        List<Question> questions = questionRepository.findByQuestionnaireId(questionnaireId);
        return dtoBuilder.buildListQuestionDto(questions);
    }

    @Override
    public void createQuestions(List<CreateQuestionDto> questions, Questionnaire questionnaire) {
        questions.forEach(q -> {
            Question question = Question.builder()
                    .questionName(q.getQuestionName())
                    .typeName(q.getQuestionType())
                    .questionnaire(questionnaire)
                    .build();

            questionRepository.save(question);
        });
    }
}
