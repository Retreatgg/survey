package com.example.survey.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateQuestionDto {

    @NotNull(message = "Вопрос не может быть пустым")
    private String questionName;
    @NotNull(message = "Тип вопроса не может быть пустым")
    private String questionType;
}
