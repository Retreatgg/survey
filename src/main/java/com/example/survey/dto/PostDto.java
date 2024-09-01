package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private List<String> images;

}
