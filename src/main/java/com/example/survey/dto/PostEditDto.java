package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostEditDto {

    private String tittle;
    private String description;
}
