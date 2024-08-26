package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateQuestionnaireDto {

    private String questionnaireName;
    private Long instituteId;
    private List<CreateQuestionDto> questionDtoList;

}
