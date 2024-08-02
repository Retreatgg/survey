package com.example.survey.service.impl;

import com.example.survey.dto.CreateQuestionDto;
import com.example.survey.dto.QuestionDto;
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

    @Override
    public List<QuestionDto> getQuestionByQuestionnaireId(Long questionnaireId) {
        List<Question> questions = questionRepository.findByQuestionnaireId(questionnaireId);
        return getDtos(questions);
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

    private List<QuestionDto> getDtos(List<Question> questions) {
        List<QuestionDto> list = new ArrayList<>();
        questions.forEach(q -> {
            list.add(QuestionDto.builder()
                            .id(q.getId())
                            .questionName(q.getQuestionName())
                            .typeName(q.getTypeName())
                    .build());
        });
        return list;
    }
}
