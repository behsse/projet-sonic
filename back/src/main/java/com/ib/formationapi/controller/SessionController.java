package com.ib.formationapi.controller;

import com.ib.formationapi.entity.Session;
import com.ib.formationapi.exception.AlreadyExistException;
import com.ib.formationapi.exception.InvalidArgumentException;
import com.ib.formationapi.exception.NotFoundException;
import com.ib.formationapi.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("id/{id}")
    public Session getSessionById(@PathVariable final Long id) {
        try {
            return sessionService.findById(id);
        } catch (NotFoundException sessionNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, sessionNotFoundException.getMessage());
        }
    }

    @GetMapping
    public List<Session> getAll() {
        return sessionService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Session create(@RequestBody Session session) {
        try {
            return sessionService.create(session);
        } catch (AlreadyExistException | InvalidArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
