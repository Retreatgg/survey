package com.example.survey.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultQuestionnaireDto {

    @NotNull(message = "Выберите институт")
    private Long instituteId;
    @NotNull(message = "Вопрос не может быть пустым")
    private Long questionId;
    @NotNull(message = "Ответ не может быть пустым")
    private String answer;
}
