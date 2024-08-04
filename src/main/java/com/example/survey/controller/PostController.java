package com.example.survey.controller;

import com.example.survey.dto.PostCreateDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.PostEditDto;
import com.example.survey.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
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
    public ResponseEntity<Page<PostDto>> getPosts(@RequestParam(value = "page", required = false) Integer page,
                                                  @RequestParam(value = "size", required = false) Integer size) {
        if(null == page) page = 0;
        if(null == size) size = 10;
        return ResponseEntity.ok(postService.getPosts(PageRequest.of(page, size)));
    }

    @PostMapping("{id}")
    public HttpStatus editPost(@PathVariable Long id, @RequestBody PostEditDto postEditDto) {
        postService.edit(id, postEditDto);
        return HttpStatus.OK;
    }
}
