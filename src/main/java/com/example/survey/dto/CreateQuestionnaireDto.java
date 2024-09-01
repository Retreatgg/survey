package com.example.survey.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateQuestionnaireDto {

    @NotNull(message = "Название анкеты не может быть пустым")
    private String questionnaireName;
    @Size(min = 1)
    private List<CreateQuestionDto> questionDtoList;

}
