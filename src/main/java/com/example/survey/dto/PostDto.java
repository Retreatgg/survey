package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {
    private Long id;
    private String tittle;
    private String description;

}
