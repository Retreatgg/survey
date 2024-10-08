package com.example.survey.controller;

import com.example.survey.dto.PostCreateDto;
import com.example.survey.dto.PostDto;
import com.example.survey.dto.PostEditDto;
import com.example.survey.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "", consumes = {"multipart/form-data"})
    public ResponseEntity<PostDto> createPost(@ModelAttribute @Valid PostCreateDto postCreateDto) {
        return ResponseEntity.ok(postService.create(postCreateDto));
    }

    @GetMapping("")
    public ResponseEntity<Page<PostDto>> getPosts(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                  @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return ResponseEntity.ok(postService.getPosts(PageRequest.of(page, size)));
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<PostDto> editPost(@PathVariable Long id, @RequestBody @Valid PostEditDto postEditDto) {
        return ResponseEntity.ok(postService.edit(id, postEditDto));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    public HttpStatus deletePost(@PathVariable Long id) {
        postService.delete(id);
        return HttpStatus.OK;
    }
}
