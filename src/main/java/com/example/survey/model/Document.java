package com.example.survey.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "documents")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documents_id_gen")
    @SequenceGenerator(name = "documents_id_gen", sequenceName = "documents_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 250)
    @NotNull
    @Column(name = "title", nullable = false, length = 250)
    private String title;

    @Size(max = 250)
    @NotNull
    @Column(name = "document_path", nullable = false, length = 250)
    private String documentPath;

}