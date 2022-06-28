package com.ib.formationapi.controller;

import com.ib.formationapi.entity.Formation;
import com.ib.formationapi.exception.AlreadyExistException;
import com.ib.formationapi.exception.NotFoundException;
import com.ib.formationapi.exception.InvalidArgumentException;
import com.ib.formationapi.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
        } catch (NotFoundException formationNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, formationNotFoundException.getMessage());
        }
    }

    @GetMapping("id/{id}")
    public Formation getFormationById(@PathVariable final Long id) {
        try {
            return formationService.findById(id);
        } catch (NotFoundException formationNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, formationNotFoundException.getMessage());
        }
    }

    @GetMapping
    public List<Formation> getAll() {
        return formationService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Formation create(@RequestBody Formation formation) {
        try {
            return formationService.create(formation);
        } catch (AlreadyExistException | InvalidArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

}
