package com.example.survey;

import com.example.survey.model.Questionnaire;
import org.springframework.data.jpa.domain.Specification;

public class QuestionnaireSpecification {

//    public Specification<Questionnaire> byInstituteName(String instituteName) {
//        return (r, q, cb) -> {
//            if(instituteName == null) {
//                cb.conjunction();
//            }
//            return cb.equal(r.get("institute").toString().toUpperCase(),
//                    instituteName.toUpperCase());
//        };
//    }
}
