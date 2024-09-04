package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionnaireShowDto {
    private Long id;
    private String questionnaireName;
}
