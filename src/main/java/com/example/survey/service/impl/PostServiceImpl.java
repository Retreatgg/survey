package com.example.survey.service.impl;

import com.example.survey.dto.PostCreateDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.PostEditDto;
import com.example.survey.model.Post;
import com.example.survey.repository.PostRepository;
import com.example.survey.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void create(PostCreateDto postCreateDto) {
        Post post = Post.builder()
                .description(postCreateDto.getDescription())
                .build();

        postRepository.save(post);
    }

    @Override
    public List<PostDto> getPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> dtos = new ArrayList<>();

        posts.forEach(p -> {
            dtos.add(PostDto.builder()
                            .id(p.getId())
                            .description(p.getDescription())
                    .build());
        });

        return dtos;
    }

    @Override
    public void edit(Long id, PostEditDto postEditDto) {
        Optional<Post> optional = postRepository.findById(id);
        if(optional.isPresent()) {
            Post post = optional.get();
            post.setDescription(postEditDto.getDescription());
            postRepository.save(post);
        } else {
            throw new IllegalArgumentException("Запись с ID: " + id + " не найдена");
        }
    }
}
