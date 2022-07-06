package com.ib.formationapi.controller;

import com.ib.formationapi.dto.DomaineDto;
import com.ib.formationapi.entity.Domaine;

import com.ib.formationapi.exception.AlreadyExistException;
import com.ib.formationapi.exception.InvalidArgumentException;
import com.ib.formationapi.exception.NotFoundException;
import com.ib.formationapi.service.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/domaines")
public class DomaineController {
    @Autowired
    private DomaineService domaineService;

    @GetMapping("intitule/{intitule}")
    public DomaineDto getDomaineByIntitule(@PathVariable final String intitule) {
        try {
            return domaineService.findByIntitule(intitule);
        } catch (NotFoundException domaineNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, domaineNotFoundException.getMessage());
        }
    }

    @GetMapping("id/{id}")
    public DomaineDto getDomaineById(@PathVariable final Long id) {
        try {
            return domaineService.findById(id);
        } catch (NotFoundException domaineNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, domaineNotFoundException.getMessage());
        }
    }

    @GetMapping
    public List<DomaineDto> getAll() {
        return domaineService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public DomaineDto create(@RequestBody Domaine domaine) {
        try {
            return domaineService.create(domaine);
        } catch (AlreadyExistException | InvalidArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

}
