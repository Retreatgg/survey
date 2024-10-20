package com.example.survey.controller;

import com.example.survey.dto.InstituteDto;
import com.example.survey.dto.InstituteEditDto;
import com.example.survey.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institutes")
@RequiredArgsConstructor
public class InstitutesController {

    private final InstituteService instituteService;
    @GetMapping()
    public ResponseEntity<List<InstituteDto>> institutes() {
        return ResponseEntity.ok(instituteService.getInstitutes());
    }

    @PutMapping("{id}")
    public ResponseEntity<InstituteDto> edit(@PathVariable Long id, @RequestBody InstituteEditDto instituteEditDto) {
        return ResponseEntity.ok(instituteService.edit(id, instituteEditDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        instituteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
