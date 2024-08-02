package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostCreateDto {

    private String description;
}
