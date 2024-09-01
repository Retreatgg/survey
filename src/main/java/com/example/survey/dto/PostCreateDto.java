package com.example.survey.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
public class PostCreateDto {

    @NotNull(message = "Заголовок новости не может быть пустым")
    private String title;
    @NotNull(message = "Описание не может быть пустым")
    private String description;
    private MultipartFile[] images;

}
