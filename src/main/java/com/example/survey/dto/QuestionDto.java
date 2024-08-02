package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {

    private Long id;
    private String questionName;
    private String typeName;
}
