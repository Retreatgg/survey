package com.example.survey.controller;

import com.example.survey.dto.PostCreateDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.PostEditDto;
import com.example.survey.model.Post;
import com.example.survey.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("posts")
public class PostController {

    private final PostService postService;

    @PostMapping("")
    public HttpStatus createPost(@RequestBody PostCreateDto postCreateDto) {
        postService.create(postCreateDto);
        return HttpStatus.OK;
    }

    @GetMapping("")
    public ResponseEntity<List<PostDto>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @PostMapping("{id}")
    public HttpStatus editPost(@PathVariable Long id, @RequestBody PostEditDto postEditDto) {
        postService.edit(id, postEditDto);
        return HttpStatus.OK;
    }
}
