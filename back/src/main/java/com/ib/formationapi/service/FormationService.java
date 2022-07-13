package com.ib.formationapi.service;

import com.ib.formationapi.dao.FormationDao;
import com.ib.formationapi.dto.FormationDto;
import com.ib.formationapi.entity.Formation;
import com.ib.formationapi.exception.AlreadyExistException;
import com.ib.formationapi.exception.NotFoundException;
import com.ib.formationapi.exception.InvalidArgumentException;
import com.ib.formationapi.mapper.FormationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * classe de service de l'entité formation
 *
 * @author ANGHARI
 */
@Service
public class FormationService {
    @Autowired
    private FormationDao formationDao;

    @Autowired
    private FormationMapper formationMapper;

    /**
     * c'est une méthode qui permet de récuperer la liste des formations
     *
     * @return la liste de formation
     */
    public List<FormationDto> findAll() {
        final List<Formation> formationsListe = formationDao.findAll();
        return formationsListe.stream().map(formation -> formationMapper.entityToDto(formation)).collect(Collectors.toList());
    }

    /**
     * c'est une méthode qui permet de récuperer une formation à partir de son id
     *
     * @param id l'id de formation qu'on cherche
     * @return une formation
     */
    public FormationDto findById(Long id) throws NotFoundException {
        Optional<Formation> optionalFormation = this.formationDao.findById(id);
        if (!optionalFormation.isPresent()) {
            throw new NotFoundException("la formation avec l'id " + id + " n'existe pas");
        }
        return formationMapper.entityToDto(optionalFormation.get());
    }

    /**
     * c'est une méthode qui permet de récuperer une formation à partir de son nom
     *
     * @param intitule l'intitule de la formation
     * @return une formation
     */
    public FormationDto findByIntitule(String intitule) throws NotFoundException {
        final Optional<Formation> optionalFormation = formationDao.findByIntitule(intitule);
        if (!optionalFormation.isPresent()) {
            throw new NotFoundException("la formation avec l'intitule " + intitule + " n'existe pas");
        }
        return formationMapper.entityToDto(optionalFormation.get());
    }

    /**
     * c'est une méthode qui permet de créer une formation
     *
     * @param formation q'on va créer
     * @return une formation
     */
    public FormationDto create(Formation formation) throws AlreadyExistException, InvalidArgumentException {
        if (formation == null) {
            throw new InvalidArgumentException("la formation ne doit pas être null");
        }
        formation.setId(null);
        if (formationDao.findByIntitule(formation.getIntitule()).isPresent()) {
            throw new AlreadyExistException("La formation avec l'intitulé " + formation.getIntitule() + " existe déja");
        }
        return formationMapper.entityToDto(formationDao.save(formation));
    }

    /**
     * c'est la méthode qui permet de mettre à jour une formation
     *
     * @param formation qu'on veut mettre à jour
     * @param id        de formation qu'on veut mettre à jour
     * @return une formation
     */
    public Formation update(Formation formation) {
        if (!this.formationDao.existsById(formation.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "la formation n'a pas été mise à jour");
        }
        return this.formationDao.save(formation);
    }

    /**
     * c'est une méthode qui permet de suppremer une formation
     *
     * @param id de formation qu'on veut supprimer
     */
    public void delete(Long id) {
        if (!this.formationDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver la fomrmation à supprimer ");
        }
        this.formationDao.deleteById(id);
        if (this.formationDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "erreur de la suppression de la formation");
        }
    }

    public List<FormationDto> findByThemeId(final Long idTheme) {
        List<Formation> formationsListe = formationDao.findAllByThemeId(idTheme);
        return formationsListe.stream().map(formation -> formationMapper.entityToDto(formation)).collect(Collectors.toList());
    }
}
