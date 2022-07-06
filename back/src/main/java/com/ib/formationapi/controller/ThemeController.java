package com.ib.formationapi.controller;

import com.ib.formationapi.dto.ThemeDto;
import com.ib.formationapi.entity.Theme;
import com.ib.formationapi.exception.AlreadyExistException;
import com.ib.formationapi.exception.InvalidArgumentException;
import com.ib.formationapi.exception.NotFoundException;
import com.ib.formationapi.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/themes")
public class ThemeController {
    @Autowired
    private ThemeService themeService;
    @GetMapping("titre/{titre}")
    public ThemeDto getThemeByTitre(@PathVariable final String titre) {
        try {
            return themeService.findByTitre(titre);
        } catch (NotFoundException themeNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, themeNotFoundException.getMessage());
        }
    }
    @GetMapping("id/{id}")
    public ThemeDto getThemeById(@PathVariable final Long id) {
        try {
            return themeService.findById(id);
        } catch (NotFoundException themeNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, themeNotFoundException.getMessage());
        }
    }
    @GetMapping
    public List<ThemeDto> getAll() {
        return themeService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ThemeDto create(@RequestBody Theme theme) {
        try {
            return themeService.create(theme);
        } catch (AlreadyExistException | InvalidArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }


}
