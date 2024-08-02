package com.example.survey.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Table(name = "QUESTIONS")
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 150)
    @Column(name = "QUESTION_NAME", length = 150)
    private String questionName;

    @Size(max = 50)
    @Column(name = "TYPE_NAME", length = 50)
    private String typeName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "QUESTIONNAIRE_ID", nullable = false)
    private Questionnaire questionnaire;

    @OneToMany(mappedBy = "question")
    private List<AnswerQuestion> answerQuestions;

}