package com.example.survey.controller;

import com.example.survey.service.ImagePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {

    private final ImagePostService imagePostService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getFile(@PathVariable(name = "name") String imageName) {
        return imagePostService.getImagesByPath(imageName);
    }
}
