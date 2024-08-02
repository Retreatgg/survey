package com.example.survey.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "QUESTIONNAIRE")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 200)
    @Column(name = "NAME_QUESTIONNAIRE", length = 200)
    private String nameQuestionnaire;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionnaire")
    private List<Question> questionList;

}