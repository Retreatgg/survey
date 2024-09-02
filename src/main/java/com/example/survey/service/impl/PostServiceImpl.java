package com.example.survey.service.impl;

import com.example.survey.dto.PostCreateDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.PostEditDto;
import com.example.survey.exceptions.PostNotFoundException;
import com.example.survey.model.Post;
import com.example.survey.repository.PostRepository;
import com.example.survey.service.ImagePostService;
import com.example.survey.service.PostService;
import com.example.survey.service.UserService;
import com.example.survey.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final ImagePostService imagePostService;
    private final DtoBuilder dtoBuilder;

    @Override
    public PostDto create(PostCreateDto postCreateDto) {
        return createPost(postCreateDto);
    }

    @Override
    public Page<PostDto> getPosts(PageRequest pageRequest) {
        Pageable pageable = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize());
        Page<Post> posts = postRepository.findAll(pageRequest);
        return new PageImpl<>(
                posts.getContent().stream()
                        .map(p -> dtoBuilder.buildPostDto(p, imagePostService.getImagesByPostId(p.getId())))
                        .collect(Collectors.toList()),
                pageable, posts.getTotalElements());
    }

    @Override
    public PostDto edit(Long id, PostEditDto postEditDto) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setDescription(postEditDto.getDescription());
        post.setTittle(postEditDto.getTitle());
        Post editedPost = postRepository.save(post);
        List<String> images = imagePostService.saveImages(postEditDto.getImages(), editedPost.getId());
        return dtoBuilder.buildPostDto(editedPost, images);
    }

    @Override
    public Post findById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Пост по ID: " + postId + " не найден"));
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = findById(id);
        return dtoBuilder.buildPostDto(post, imagePostService.getImagesByPostId(id));
    }

    private PostDto createPost(PostCreateDto dto) {
        Post post = Post.builder()
                .author(userService.findById(1L))
                .tittle(dto.getTitle())
                .description(dto.getDescription())
                .datePublic(LocalDateTime.now())
                .build();
        Post newPost = postRepository.save(post);
        List<String> images = imagePostService.saveImages(Arrays.stream(dto.getImages()).toList(), newPost.getId());
        return dtoBuilder.buildPostDto(newPost, images);
    }
}
