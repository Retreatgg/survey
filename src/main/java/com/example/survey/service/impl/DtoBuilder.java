package com.example.survey.service.impl;

import com.example.survey.dto.InstituteDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.QuestionDto;
import com.example.survey.dto.QuestionnaireDto;
import com.example.survey.model.Institute;
import com.example.survey.model.Post;
import com.example.survey.model.Question;
import com.example.survey.model.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DtoBuilder {

    public PostDto buildPostDto(Post model, List<String> images) {
        return PostDto.builder()
                .title(model.getTittle())
                .id(model.getId())
                .description(model.getDescription())
                .images(images)
                .build();
    }

    public QuestionnaireDto questionnaireDto(Questionnaire model) {
        return QuestionnaireDto.builder()
                .nameQuestionnaire(model.getNameQuestionnaire())
                .id(model.getId())
                .build();
    }

    public InstituteDto toDto(Institute model) {
        return InstituteDto.builder()
                .name(model.getName())
                .id(model.getId())
                .build();
    }

    public QuestionnaireDto builderQuestionnaireDto(Questionnaire questionnaire) {
        return QuestionnaireDto.builder()
                .id(questionnaire.getId())
                .nameQuestionnaire(questionnaire.getNameQuestionnaire())
                .build();
    }

    public List<QuestionDto> buildListQuestionDto(List<Question> questions) {
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
