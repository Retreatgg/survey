package com.example.survey.service.impl;

import com.example.survey.dto.CreateDocumentDto;
import com.example.survey.dto.DocumentDto;
import com.example.survey.model.Document;
import com.example.survey.repository.DocumentRepository;
import com.example.survey.service.DocumentService;
import com.example.survey.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final FileUtil fileUtil;
    private final DocumentRepository documentRepository;
    @Override
    public DocumentDto create(CreateDocumentDto createDocumentDto) {
        Document document = Document.builder()
                .title(createDocumentDto.getTitle())
                .documentPath(fileUtil.saveFile(createDocumentDto.getDocument(), "/images"))
                .build();
        documentRepository.save(document);
        return buildDto(document);
    }

    @Override
    public DocumentDto findById(Long id) {
        Document document = documentRepository.findById(id).orElseThrow();
        return buildDto(document);
    }

    @Override
    public List<DocumentDto> getAll() {
        List<Document> documents = documentRepository.findAll();
        return documents.stream().map(this::buildDto).toList();
    }


    private DocumentDto buildDto(Document model) {
        return DocumentDto.builder()
                .id(model.getId())
                .documentPath(model.getDocumentPath())
                .title(model.getTitle())
                .build();
    }
}
