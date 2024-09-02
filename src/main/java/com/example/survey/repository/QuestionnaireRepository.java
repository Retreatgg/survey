package com.example.survey.repository;

import com.example.survey.model.AnswerQuestion;
import com.example.survey.model.Questionnaire;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

    @Query("select q.id, q.nameQuestionnaire from Questionnaire q")
    List<Questionnaire> findAllNames();
}