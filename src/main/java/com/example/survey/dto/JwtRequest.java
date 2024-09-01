package com.example.survey.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JwtRequest {
    @Email(message = "Неправильный формат почты")
    @NotNull(message = "Почта не может быть пустой")
    private String email;
    @NotNull(message = "Пароль не может быть пустым")
    private String password;
}
