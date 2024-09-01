package com.example.survey.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
public class PostCreateDto {

    private String title;
    private String description;
    private MultipartFile[] images;

}
