package com.example.survey.service.impl;

import com.example.survey.dto.*;
import com.example.survey.model.AnswerQuestion;
import com.example.survey.model.Questionnaire;
import com.example.survey.repository.QuestionAnswerRepository;
import com.example.survey.repository.QuestionRepository;
import com.example.survey.repository.QuestionnaireRepository;
import com.example.survey.service.QuestionService;
import com.example.survey.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;
    private final QuestionAnswerRepository questionAnswerRepository;
    private final QuestionnaireService questionnaireService;

    @Override
    public QuestionnaireDto getQuestionnaireById(Long id) {
        return builderQuestionnaireDto(id);
    }

    @Override
    public List<QuestionAnswersDto> getAnswersByQuestionnaireId(Long id) {
        List<AnswerQuestion> answers = questionnaireRepository.getAnswerPercentages(id);
        Map<String, Map<String, Integer>> countMap = new HashMap<>();
        Map<String, Integer> totalCountMap = new HashMap<>();
        Map<String, Boolean> isIntegerQuestionMap = new HashMap<>();

        for (AnswerQuestion answer : answers) {
            String questionName = answer.getQuestion().getQuestionName();
            String answerText = answer.getAnswer();
            boolean isIntegerQuestion = answer.getQuestion().getTypeName().equals("INTEGER");

            countMap.putIfAbsent(questionName, new HashMap<>());
            Map<String, Integer> answerCountMap = countMap.get(questionName);
            answerCountMap.put(answerText, answerCountMap.getOrDefault(answerText, 0) + 1);

            totalCountMap.put(questionName, totalCountMap.getOrDefault(questionName, 0) + 1);
            isIntegerQuestionMap.put(questionName, isIntegerQuestion);
        }

        List<QuestionAnswersDto> result = new ArrayList<>();
        for (String questionName : countMap.keySet()) {
            boolean isIntegerQuestion = isIntegerQuestionMap.get(questionName);
            if (isIntegerQuestion) {
                int totalCount = totalCountMap.get(questionName);
                Map<String, Double> answerPercentageMap = new HashMap<>();
                for (int i = 1; i <= 5; i++) {
                    String answerText = String.valueOf(i);
                    int count = countMap.get(questionName).getOrDefault(answerText, 0);
                    double percentage = (totalCount == 0) ? 0 : (count * 100.0) / totalCount;
                    answerPercentageMap.put(answerText, Math.ceil(percentage));
                }
                result.add(new QuestionAnswersDto(questionName, answerPercentageMap));
            } else {
                List<String> answersList = new ArrayList<>(countMap.get(questionName).keySet());
                result.add(new QuestionAnswersDto(questionName, answersList));
            }
        }

        return result;
    }

    @Override
    public void saveResult(List<ResultQuestionnaireDto> questionnaireDto, Long id) {
        questionnaireDto.forEach(ql -> {

            questionAnswerRepository.save(AnswerQuestion.builder()
                    .question(questionRepository.findById(ql.getQuestionId()).get())
                    .answer(ql.getAnswer())
                    .build());
        });

    }

    @Override
    public void create(CreateQuestionnaireDto create) {
        Questionnaire questionnaire = Questionnaire.builder()
                .nameQuestionnaire(create.getQuestionnaireName())
                .build();

        Questionnaire newQuestionnaire = questionnaireRepository.save(questionnaire);

        questionService.createQuestions(create.getQuestionDtoList(), newQuestionnaire);
    }

    private QuestionnaireDto builderQuestionnaireDto(Long questionnaireId) {
        Optional<Questionnaire> optional = questionnaireRepository.findById(questionnaireId);
        if(optional.isEmpty()) throw new IllegalArgumentException("Анкета с ID: " + questionnaireId + " не найден");
        List<QuestionDto> questions = questionService.getQuestionByQuestionnaireId(questionnaireId);

        return QuestionnaireDto.builder()
                .id(optional.get().getId())
                .nameQuestionnaire(optional.get().getNameQuestionnaire())
                .questionList(questions)
                .build();
    }
}
