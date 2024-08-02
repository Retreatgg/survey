package com.example.survey.service;

import com.example.survey.dto.PostCreateDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.PostEditDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    void create(PostCreateDto postCreateDto);

    List<PostDto> getPosts();

    void edit(Long id, PostEditDto postEditDto);
}
