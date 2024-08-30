package com.example.survey.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ImagePostService {

    ResponseEntity<?> getImagesByPath(String path);
    List<String> saveImages(List<MultipartFile> files, Long postId);
    List<String> getImagesByPostId(Long postId);
}
