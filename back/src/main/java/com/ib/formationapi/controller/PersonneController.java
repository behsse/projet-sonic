package com.ib.formationapi.controller;

import com.ib.formationapi.entity.Personne;
import com.ib.formationapi.exception.AlreadyExistException;
import com.ib.formationapi.exception.InvalidArgumentException;
import com.ib.formationapi.exception.NotFoundException;
import com.ib.formationapi.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Classe controlleur pour la table Personne
 *
 * @author Ch. Vasseur
 */

@RestController
@RequestMapping("/utilisateur")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @GetMapping("id/{id}")
    public Personne getPersonneById(@PathVariable final Long id) {
        try {
            return personneService.findById(id);
        } catch (NotFoundException personneNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, personneNotFoundException.getMessage());
        }
    }

    @GetMapping
    public List<Personne> getAll() {
        return personneService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Personne create(@RequestBody Personne personne) {
        try {
            return personneService.create(personne);
        } catch (AlreadyExistException | InvalidArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
