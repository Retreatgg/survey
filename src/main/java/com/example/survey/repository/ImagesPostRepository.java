package com.example.survey.repository;

import com.example.survey.model.ImagesPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesPostRepository extends JpaRepository<ImagesPost, Long> {

    @Query("select ip.imageName from ImagesPost ip where ip.id = :postId")
    List<String> findImagesByPostId(Long postId);
}