package com.example.survey.specifications;

import com.example.survey.model.AnswerQuestion;
import org.springframework.data.jpa.domain.Specification;

public class AnswerQuestionSpecification {

    Specification<AnswerQuestion> hasQuestionnaireId(Long questionnaireId) {
        return (r, q, cb) -> {
            if(questionnaireId == null) return cb.conjunction();
            return cb.equal(r.get("question").get("questionnaire").get("id"), questionnaireId);
        };
    }
    
}
