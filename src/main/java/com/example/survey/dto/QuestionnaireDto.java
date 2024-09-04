package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionnaireDto {

    private Long id;
    private String nameQuestionnaire;

}
