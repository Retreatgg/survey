package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateQuestionDto {

    private String questionName;
    private String questionType;
}
