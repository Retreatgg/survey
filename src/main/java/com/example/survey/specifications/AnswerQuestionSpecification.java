package com.example.survey.specifications;

import com.example.survey.model.AnswerQuestion;
import com.example.survey.model.Question;
import com.example.survey.model.Questionnaire;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class AnswerQuestionSpecification {

    public static Specification<AnswerQuestion> hasInstituteName(String instituteName) {
        return (r, q, cb) -> {
            if(instituteName.equals("default")) return cb.conjunction();
            return cb.equal(r.get("question").get("questionnaire").get("institute").get("name"), instituteName);
        };
    }

    public static Specification<AnswerQuestion> hasQuestionnaireId(Long questionnaireId) {
        return (root, query, criteriaBuilder) -> {
            Join<Question, AnswerQuestion> authorsBook = root.join("questions");
            return criteriaBuilder.equal(authorsBook.get("questionnaire").get("id"), questionnaireId);
        };
    }
    
}
