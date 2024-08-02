package com.example.survey.repository;

import com.example.survey.model.AnswerQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<AnswerQuestion, Long> {
}
