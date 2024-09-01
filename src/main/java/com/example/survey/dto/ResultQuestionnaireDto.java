package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultQuestionnaireDto {

    private Long instituteId;
    private Long questionId;
    private String answer;
}
