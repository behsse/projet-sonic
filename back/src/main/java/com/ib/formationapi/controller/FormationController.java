package com.ib.formationapi.controller;

import com.ib.formationapi.entity.Formation;
import com.ib.formationapi.exception.FormationNotFoundException;
import com.ib.formationapi.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/formations")
public class FormationController {

    @Autowired
    private FormationService formationService;


    @GetMapping("intitule/{intitule}")
    public Formation getFormationByIntitule(@PathVariable final String intitule) {
        try {
           return formationService.findByIntitule(intitule);
        } catch (FormationNotFoundException formationNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, formationNotFoundException.getMessage());
        }
    }

    @GetMapping("id/{id}")
    public Formation getFormationById(@PathVariable final Long id) {
        try {
            return formationService.findById(id);
        } catch (FormationNotFoundException formationNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, formationNotFoundException.getMessage());
        }
    }
    @GetMapping
    public List<Formation> getAll() {
            return formationService.findAll();
    }

}
