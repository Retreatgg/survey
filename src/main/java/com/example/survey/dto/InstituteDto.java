package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstituteDto {
    private Long id;
    private String name;
}
