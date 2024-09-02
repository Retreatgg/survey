package com.example.survey.service.impl;

import com.example.survey.dto.PostDto;
import com.example.survey.dto.QuestionnaireDto;
import com.example.survey.model.Post;
import com.example.survey.model.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
