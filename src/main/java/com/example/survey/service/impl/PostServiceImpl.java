package com.example.survey.service.impl;

import com.example.survey.dto.PostCreateDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.PostEditDto;
import com.example.survey.model.Post;
import com.example.survey.repository.PostRepository;
import com.example.survey.service.PostService;
import com.example.survey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
    public List<PostDto> getPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(dtoBuilder::buildPostDto)
                .toList();
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
