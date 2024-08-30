package com.example.survey.service.impl;

import com.example.survey.model.ImagesPost;
import com.example.survey.repository.ImagesPostRepository;
import com.example.survey.repository.PostRepository;
import com.example.survey.service.ImagePostService;
import com.example.survey.service.PostService;
import com.example.survey.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagePostServiceImpl implements ImagePostService {

    private final ImagesPostRepository imagesPostRepository;
    private final PostService postService;
    private final FileUtil fileUtil;


    @Override
    public ResponseEntity<?> getImagesByPath(String path) {
        return fileUtil.getOutputFile(path, "/images", MediaType.ALL);
    }

    @Override
    public List<String> saveImages(List<MultipartFile> files, Long postId) {
        List<String> names = new ArrayList<>();
        for (MultipartFile file : files) {
            String name = fileUtil.saveUploadedFile(file, "images", postId);
            ImagesPost imagesPost = ImagesPost.builder()
                    .imageName(name)
                    .post(postService.findById(postId))
                    .build();
            imagesPostRepository.save(imagesPost);
            names.add(name);
        }
        return names;
    }

    @Override
    public List<String> getImagesByPostId(Long postId) {
        return imagesPostRepository.findImagesByPostId(postId);
    }
}
