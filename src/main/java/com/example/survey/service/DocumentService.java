package com.example.survey.service;

import com.example.survey.dto.CreateDocumentDto;
import com.example.survey.dto.DocumentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentService {
    DocumentDto create(CreateDocumentDto createDocumentDto);
    DocumentDto findById(Long id);
    List<DocumentDto> getAll();
}
