package com.ib.formationapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ib.formationapi.dao.ThemeDao;
import com.ib.formationapi.dto.ThemeDto;
import com.ib.formationapi.entity.Theme;
import com.ib.formationapi.exception.AlreadyExistException;
import com.ib.formationapi.exception.InvalidArgumentException;
import com.ib.formationapi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * classe de service de l'entité service
 *
 * @author ANGHARI
 */

@Service
public class ThemeService {
    @Autowired
    private ThemeDao themeDao;

//    @Autowired
//    private ObjectMapper objectMapper;
//
//    public ThemeDto foo(Theme theme){
//        return this.objectMapper.convertValue(theme,ThemeDto.class);
//    }

    /**
     * permet de récuperer la liste des themes
     *
     * @return une liste de theme
     */
    public List<Theme> findAll() {
        return this.themeDao.findAll();
    }

    /**
     * permet de récuperer un theme à partir de son id
     *
     * @param id de theme
     * @return un theme
     * @throws NotFoundException
     */
    public Theme findById(Long id) throws NotFoundException {
        Optional<Theme> optionalTheme = this.themeDao.findById(id);
        if (!optionalTheme.isPresent()) {
            throw new NotFoundException("le theme avec l'id " + id + " n'existe pas");
        }
        return optionalTheme.get();
    }

    public Theme findByTitre(String titre) throws NotFoundException {
        final Optional<Theme> optionalTheme = themeDao.findByTitre(titre);
        if (!optionalTheme.isPresent()) {
            throw new NotFoundException("le theme avec le titre " + titre + " n'exsiste pas");
        }
        return optionalTheme.get();
    }

    public Theme create(Theme theme) throws AlreadyExistException, InvalidArgumentException {
        if (theme == null) {
            throw new InvalidArgumentException("le theme ne doit pas être null");
        }
        theme.setId(null);
        if (themeDao.findByTitre(theme.getTitre()).isPresent()) {
            throw new AlreadyExistException("Le theme avec le titre " + theme.getTitre() + "existe déja");
        }
        return this.themeDao.save(theme);
    }

    public Theme update(Theme theme, Long id) {
        if (!this.themeDao.existsById(theme.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "le theme n'a pas été mise à jour");
        }
        return this.themeDao.save(theme);
    }

    public void delete(Long id) {
        if (!this.themeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le theme à supprimer");
        }
        this.themeDao.deleteById(id);
        if (this.themeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "erreur de la supprission du theme");
        }
    }
}
