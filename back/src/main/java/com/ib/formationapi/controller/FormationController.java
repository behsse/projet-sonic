package com.ib.formationapi.controller;

import com.ib.formationapi.dto.FormationDto;
import com.ib.formationapi.entity.Formation;
import com.ib.formationapi.mapper.FormationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private FormationMapper formationMapper;
    @GetMapping
    public ResponseEntity<FormationDto> getFormation() {
        final Formation formation = new Formation();
        
        final FormationDto formationDto = formationMapper.entityToDto(formation);
        return ResponseEntity.ok(formationDto);
    }


}
