package com.example.survey.service.impl;

import com.example.survey.dto.PostDto;
import com.example.survey.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DtoBuilder {

    public PostDto buildPostDto(Post model, List<String> images) {
        return PostDto.builder()
                .tittle(model.getTittle())
                .id(model.getId())
                .description(model.getDescription())
                .images(images)
                .build();
    }


}
