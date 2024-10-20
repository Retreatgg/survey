package com.example.survey.service;

import com.example.survey.dto.InstituteDto;
import com.example.survey.dto.InstituteEditDto;
import com.example.survey.model.Institute;

import java.util.List;

public interface InstituteService {

    Institute getInstituteById(Long instituteId);
    List<InstituteDto> getInstitutes();
    InstituteDto edit(Long id, InstituteEditDto instituteEditDto);
    void delete(Long id);
}
