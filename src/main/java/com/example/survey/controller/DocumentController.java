package com.example.survey.controller;

import com.example.survey.dto.CreateDocumentDto;
import com.example.survey.dto.DocumentDto;
import com.example.survey.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping()
    public ResponseEntity<DocumentDto> create(@ModelAttribute CreateDocumentDto createDocumentDto) {
        return ResponseEntity.ok(documentService.create(createDocumentDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<DocumentDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(documentService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<DocumentDto>> documents() {
        return ResponseEntity.ok(documentService.getAll());
    }
}
