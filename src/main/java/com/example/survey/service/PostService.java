package com.example.survey.service;

import com.example.survey.dto.PostCreateDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.PostEditDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface PostService {
    void create(PostCreateDto postCreateDto);

    Page<PostDto> getPosts(PageRequest pageRequest);

    void edit(Long id, PostEditDto postEditDto);
}
