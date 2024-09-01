package com.example.survey.service;

import com.example.survey.dto.PostCreateDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.PostEditDto;
import com.example.survey.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface PostService {
    PostDto create(PostCreateDto postCreateDto);
    Page<PostDto> getPosts(PageRequest pageRequest);
    PostDto edit(Long id, PostEditDto postEditDto);
    Post findById(Long postId);
    void delete(Long id);
    PostDto getPostById(Long id);
}
