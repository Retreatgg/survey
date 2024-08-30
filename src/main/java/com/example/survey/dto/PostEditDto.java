package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
public class PostEditDto {

    private String tittle;
    private String description;
    private List<MultipartFile> images;
}
