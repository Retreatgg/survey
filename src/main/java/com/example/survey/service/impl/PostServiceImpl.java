package com.example.survey.service.impl;

import com.example.survey.dto.PostCreateDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.PostEditDto;
import com.example.survey.model.Post;
import com.example.survey.repository.PostRepository;
import com.example.survey.service.PostService;
import com.example.survey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final DtoBuilder dtoBuilder;

    @Override
    public void create(PostCreateDto postCreateDto) {
        Post post = createPost(postCreateDto);
        postRepository.save(post);
    }

    @Override
    public Page<PostDto> getPosts(PageRequest pageRequest) {
        Pageable pageable = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize());
        Page<Post> posts = postRepository.findAll(pageRequest);
        return new PageImpl<>(
                posts.getContent().stream()
                .map(dtoBuilder::buildPostDto).collect(Collectors.toList()),
                pageable, posts.getTotalElements());
    }

    @Override
    public void edit(Long id, PostEditDto postEditDto) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setDescription(postEditDto.getDescription());
        post.setTittle(postEditDto.getTittle());
        postRepository.save(post);
    }

    private Post createPost(PostCreateDto dto) {
        return Post.builder()
                .author(userService.findById(1L))
                .tittle(dto.getTittle())
                .description(dto.getDescription())
                .datePublic(LocalDateTime.now())
                .build();
    }
}
